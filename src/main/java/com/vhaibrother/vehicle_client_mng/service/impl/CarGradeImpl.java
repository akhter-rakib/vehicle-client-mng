package com.vhaibrother.vehicle_client_mng.service.impl;

import com.vhaibrother.vehicle_client_mng.dto.CarGradeDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.entity.CarGrade;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import com.vhaibrother.vehicle_client_mng.repository.CarGradeRepository;
import com.vhaibrother.vehicle_client_mng.service.CarGradeService;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarGradeImpl implements CarGradeService {
    private final CarGradeRepository carGradeRepository;
    private final ModelMapper modelMapper;
    private final String root = "CarGrade";

    public CarGradeImpl(CarGradeRepository carGradeRepository, ModelMapper modelMapper) {
        this.carGradeRepository = carGradeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response save(CarGradeDto carGradeDto) {
        CarGrade carGradeName = getCarGradeByName(carGradeDto);
        if (carGradeName != null) {
            return ResponseBuilder.getFailureResponse(HttpStatus.IM_USED, "This" + root + "Already Created");
        }
        CarGrade carGrade;
        carGrade = modelMapper.map(carGradeDto, CarGrade.class);
        carGrade = carGradeRepository.save(carGrade);
        if (carGrade != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + "Has been Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, CarGradeDto carGradeDto) {
        CarGrade carGradeName = getCarGradeByName(carGradeDto);
        if (carGradeName != null) {
            return ResponseBuilder.getFailureResponse(HttpStatus.IM_USED, "This" + root + "Already Created");
        }
        CarGrade carGrade = carGradeRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (carGrade != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            carGrade = modelMapper.map(carGradeDto, CarGrade.class);
            carGrade = carGradeRepository.save(carGrade);
            if (carGrade != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " updated Successfully", null);
            }

            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Occurs");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getById(Long id) {
        CarGrade carGrade = carGradeRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (carGrade != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            CarGradeDto carGradeDto = modelMapper.map(carGrade, CarGradeDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " retrieved Successfully", carGradeDto);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getAll() {
        List<CarGrade> carGradeList = carGradeRepository.list(ActiveStatus.ACTIVE.getValue());
        List<CarGradeDto> carGradeDtoList = this.getCarGrade(carGradeList);
        if (carGradeDtoList.isEmpty() || carGradeDtoList == null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "There is No " + root, null);
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", carGradeDtoList);
    }

    @Override
    public Response del(Long id) {
        CarGrade carGrade = carGradeRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (carGrade != null) {
            carGrade.setActiveStatus(ActiveStatus.DELETE.getValue());
            carGrade = carGradeRepository.save(carGrade);
            if (carGrade != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Delete SucessFully", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    private List<CarGradeDto> getCarGrade(List<CarGrade> carGradeList) {
        List<CarGradeDto> carGradeDtoList = new ArrayList<>();
        carGradeList.forEach(carGrade -> {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            CarGradeDto carGradeDto = modelMapper.map(carGrade, CarGradeDto.class);
            carGradeDtoList.add(carGradeDto);
        });
        return carGradeDtoList;
    }

    private CarGrade getCarGradeByName(CarGradeDto carGradeDto) {
        CarGrade carGrade = carGradeRepository.getCarGradeByGradeName(carGradeDto.getGradeName());
        return carGrade;
    }
}
