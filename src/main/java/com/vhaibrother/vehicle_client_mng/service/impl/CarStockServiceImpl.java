package com.vhaibrother.vehicle_client_mng.service.impl;

import com.vhaibrother.vehicle_client_mng.dto.CarStockDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.entity.*;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import com.vhaibrother.vehicle_client_mng.repository.*;
import com.vhaibrother.vehicle_client_mng.service.CarStockService;
import com.vhaibrother.vehicle_client_mng.shared.media.Media;
import com.vhaibrother.vehicle_client_mng.shared.media.MediaComponent;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import javassist.NotFoundException;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarStockServiceImpl implements CarStockService {

    @Autowired
    private MediaComponent mediaComponent;
    @Autowired
    private CarCompanyRepository carCompanyRepository;
    @Autowired
    private CarModelRepository carModelRepository;
    @Autowired
    private CarGradeRepository carGradeRepository;
    @Autowired
    private ClientRepository clientRepository;

    private final CarStockRepository carStockRepository;
    private final ModelMapper modelMapper;
    private static String root = "CAR STOCK";

    public CarStockServiceImpl(CarStockRepository carStockRepository, ModelMapper modelMapper) {
        this.carStockRepository = carStockRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public Response save(CarStockDto carStockDto) throws Exception{
        CarStock carStock = null;
        if (carStockDto.getId() != null) {
            carStock = carStockRepository.findById(carStockDto.getId()).orElseThrow(() -> new NotFoundException("Car Stock not found"));
        } else {
            carStock = new CarStock();
        }
        CarCompany company = carCompanyRepository.findById(carStockDto.getCarCompanyId()).orElseThrow(() -> new NotFoundException("Car Company not found"));
        CarModel model = carModelRepository.findById(carStockDto.getCarModelId()).orElseThrow(() -> new NotFoundException("Car Brand/Model not found"));
        CarGrade grade = carGradeRepository.findById(carStockDto.getCarGradeId()).orElseThrow(() -> new NotFoundException("Car Grade not found"));
        Client client = clientRepository.findById(carStockDto.getClientId()).orElseThrow(() -> new NotFoundException("Client/Importer not found"));
        Media media = null;
        if (carStockDto.getImagePath() != null) {
            media = mediaComponent.saveMedia(carStockDto.getImagePath());
        }
        //carStock = modelMapper.map(carStockDto, CarStock.class);
        carStock.setCarCompany(company);
        carStock.setCarModel(model);
        carStock.setCarGrade(grade);
        carStock.setEngineNo(carStockDto.getEngineNo());
        carStock.setChassisNo(carStockDto.getChassisNo());
        carStock.setYearOfModel(carStockDto.getYearOfModel());
        carStock.setClient(client);
        carStock.setCarType(carStockDto.getCarType());
        carStock.setColor(carStockDto.getColor());
        carStock.setPrice(carStockDto.getPrice());
        carStock.setCarAuction(carStockDto.getCarAuction());
        carStock.setAvailableStatus(carStockDto.getAvailableStatus());
        if(null != media) carStock.setMedia(media);
        carStock = carStockRepository.save(carStock);
        if (carStock != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + "Has been Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, CarStockDto carStockDto) {
        CarStock carStock = carStockRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (carStock != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            carStock = modelMapper.map(carStockDto, CarStock.class);
            carStock = carStockRepository.save(carStock);
            if (carStock != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " updated Successfully", null);
            }

            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Occurs");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getById(Long id) {
        CarStock carStock = carStockRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (carStock != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            CarStockDto productDto = modelMapper.map(carStock, CarStockDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " retrieved Successfully", productDto);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response del(Long id) {
        CarStock carStock = carStockRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (carStock != null) {
            carStock.setActiveStatus(ActiveStatus.DELETE.getValue());
            carStock = carStockRepository.save(carStock);
            if (carStock != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Delete SucessFully", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getAll() {
        List<CarStock> carStockList = carStockRepository.list(ActiveStatus.ACTIVE.getValue());
        List<CarStockDto> CarStockDtoList = this.getCarStock(carStockList);
        if (CarStockDtoList.isEmpty() || CarStockDtoList == null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "There is No  CarStock", null);
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", CarStockDtoList);
    }

    @Override
    public Response getByCarType(String carType) {
        List<CarStock> carStockList = carStockRepository.list(ActiveStatus.ACTIVE.getValue());
        //List<CarStock> carStockList = carStockRepository.getByCarType(carType);
        List<CarStockDto> CarStockDtoList = this.getCarStock(carStockList);
        if (CarStockDtoList.isEmpty() || CarStockDtoList == null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "There is No  CarStock", null);
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", CarStockDtoList);

    }

    private List<CarStockDto> getCarStock(List<CarStock> carStocks) {
        List<CarStockDto> CarStockDtoList = new ArrayList<>();
        carStocks.forEach(carStock -> {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            CarStockDto CarStockDto = modelMapper.map(carStock, CarStockDto.class);
            CarStockDtoList.add(CarStockDto);
        });
        return CarStockDtoList;
    }
}
