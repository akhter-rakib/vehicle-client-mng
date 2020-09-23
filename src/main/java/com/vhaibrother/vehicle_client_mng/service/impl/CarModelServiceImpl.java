package com.vhaibrother.vehicle_client_mng.service.impl;

import com.vhaibrother.vehicle_client_mng.dto.CarGradeDto;
import com.vhaibrother.vehicle_client_mng.dto.CarModelDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.entity.CarModel;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import com.vhaibrother.vehicle_client_mng.repository.CarModelRepository;
import com.vhaibrother.vehicle_client_mng.service.CarModelService;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarModelServiceImpl implements CarModelService {
    private final CarModelRepository carModelRepository;
    private final ModelMapper modelMapper;
    private final String root = "CarModel";

    public CarModelServiceImpl(CarModelRepository carModelRepository, ModelMapper modelMapper) {
        this.carModelRepository = carModelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response save(CarModelDto carModelDto) {
        CarModel carModelName = getColorByName(carModelDto);
        if (carModelName != null) {
            return ResponseBuilder.getFailureResponse(HttpStatus.IM_USED, "This" + root + "Already Created");
        }
        CarModel carModel;
        carModel = modelMapper.map(carModelDto, CarModel.class);
        carModel = carModelRepository.save(carModel);
        if (carModel != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + "Has been Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, CarModelDto carModelDto) {
        return null;
    }

    @Override
    public Response getById(Long id) {
        return null;
    }

    @Override
    public Response del(Long id) {
        return null;
    }

    @Override
    public Response getAll() {
        List<CarModel> carModelList = carModelRepository.list(ActiveStatus.ACTIVE.getValue());
        List<CarModelDto> carModelDto = this.getCarModel(carModelList);
        if (carModelDto.isEmpty() || carModelDto == null) {
            return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, "There is No  Color");
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", carModelDto);
    }

    private CarModel getColorByName(CarModelDto carModelDto) {
        CarModel carModel = carModelRepository.getCarModelsByCarModelName(carModelDto.getCarModelName());
        return carModel;
    }

    private List<CarModelDto> getCarModel(List<CarModel> carModel) {
        List<CarModelDto> carModelDtoList = new ArrayList<>();
        carModel.forEach(model -> {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            CarModelDto carModelDto = modelMapper.map(model, CarModelDto.class);
            carModelDtoList.add(carModelDto);
        });
        return carModelDtoList;
    }
}
