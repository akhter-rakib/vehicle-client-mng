package com.vhaibrother.vehicle_client_mng.service.impl;

import com.vhaibrother.vehicle_client_mng.dto.CarStockDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.entity.CarStock;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import com.vhaibrother.vehicle_client_mng.repository.CarStockRepository;
import com.vhaibrother.vehicle_client_mng.service.CarStockService;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarStockServiceImpl implements CarStockService {

    private final CarStockRepository carStockRepository;
    private final ModelMapper modelMapper;
    private static String root = "CAR STOCK";

    public CarStockServiceImpl(CarStockRepository carStockRepository, ModelMapper modelMapper) {
        this.carStockRepository = carStockRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response save(CarStockDto carStockDto) {
        CarStock carStock;
        carStock = modelMapper.map(carStockDto, CarStock.class);
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
