package com.vhaibrother.vehicle_client_mng.service.impl;

import com.vhaibrother.vehicle_client_mng.dto.CarNameDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.entity.CarName;
import com.vhaibrother.vehicle_client_mng.repository.CarNameRepository;
import com.vhaibrother.vehicle_client_mng.service.CarNameService;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CarNameServiceImpl implements CarNameService {

    private final ModelMapper modelMapper;
    private final CarNameRepository carNameRepository;

    public CarNameServiceImpl(ModelMapper modelMapper, CarNameRepository carNameRepository) {
        this.modelMapper = modelMapper;
        this.carNameRepository = carNameRepository;
    }

    @Override
    public Response save(CarNameDto carNameDto) {
        CarName carName;
        //modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        carName = modelMapper.map(carNameDto, CarName.class);
        carName = carNameRepository.save(carName);
        if (carName != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, "Car and brand Name SuccessFully Saved", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Some thing is wrong in Server");
    }

    @Override
    public Response update(Long id, CarNameDto carNameDto) {
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
        return null;
    }
}
