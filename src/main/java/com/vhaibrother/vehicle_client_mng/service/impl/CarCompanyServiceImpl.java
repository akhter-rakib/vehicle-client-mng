package com.vhaibrother.vehicle_client_mng.service.impl;

import com.vhaibrother.vehicle_client_mng.dto.CarCompanyDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.entity.CarCompany;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import com.vhaibrother.vehicle_client_mng.repository.CarCompanyRepository;
import com.vhaibrother.vehicle_client_mng.service.CarCompanyService;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarCompanyServiceImpl implements CarCompanyService {
    private final CarCompanyRepository carCompanyRepository;
    private final ModelMapper modelMapper;
    private static String root = "CarCompany";

    public CarCompanyServiceImpl(CarCompanyRepository carCompanyRepository, ModelMapper modelMapper) {
        this.carCompanyRepository = carCompanyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response save(CarCompanyDto carCompanyDto) {
        CarCompany carCompanyName = getCarCompanyByName(carCompanyDto);
        if (carCompanyName != null) {
            return ResponseBuilder.getFailureResponse(HttpStatus.IM_USED, "This" + root + "Already Created");
        }
        CarCompany carCompany;
        carCompany = modelMapper.map(carCompanyDto, CarCompany.class);
        carCompany = carCompanyRepository.save(carCompany);
        if (carCompany != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + "Has been Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, CarCompanyDto carCompanyDto) {
        CarCompany carCompanyName = getCarCompanyByName(carCompanyDto);
        if (carCompanyName != null && carCompanyName.getId() != id) {
            return ResponseBuilder.getFailureResponse(HttpStatus.IM_USED, "This " + root + "Already Created");
        }
        CarCompany carCompany = carCompanyRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (carCompany != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            carCompany = modelMapper.map(carCompanyDto, CarCompany.class);
            carCompany = carCompanyRepository.save(carCompany);
            if (carCompany != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " updated Successfully", null);
            }

            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Occurs");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getById(Long id) {
        CarCompany carCompany = carCompanyRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (carCompany != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            CarCompanyDto carCompanyDto = modelMapper.map(carCompany, CarCompanyDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " retrieved Successfully", carCompanyDto);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response del(Long id) {
        CarCompany carCompany = carCompanyRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (carCompany != null) {
            carCompany.setActiveStatus(ActiveStatus.DELETE.getValue());
            carCompany = carCompanyRepository.save(carCompany);
            if (carCompany != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Delete SucessFully", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getAll() {
        List<CarCompany> carCompanyList = carCompanyRepository.list(ActiveStatus.ACTIVE.getValue());
        List<CarCompanyDto> carCompanyDto = this.getCarCompany(carCompanyList);
        if (carCompanyDto.isEmpty() || carCompanyDto == null) {
            return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, "There is No  Color");
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", carCompanyDto);
    }

    private CarCompany getCarCompanyByName(CarCompanyDto carCompanyDto) {
        CarCompany carCompany = carCompanyRepository.getCarCompanyByCarCompanyName(carCompanyDto.getCarCompanyName());
        return carCompany;
    }

    private List<CarCompanyDto> getCarCompany(List<CarCompany> carCompany) {
        List<CarCompanyDto> carCompanyDtoList = new ArrayList<>();
        carCompany.forEach(model -> {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            CarCompanyDto carCompanyDto = modelMapper.map(model, CarCompanyDto.class);
            carCompanyDtoList.add(carCompanyDto);
        });
        return carCompanyDtoList;
    }
}
