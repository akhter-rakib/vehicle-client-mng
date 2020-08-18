package com.vhaibrother.vehicle_client_mng.service.impl;

import com.vhaibrother.vehicle_client_mng.dto.ColorDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.entity.Color;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import com.vhaibrother.vehicle_client_mng.repository.ColorRepository;
import com.vhaibrother.vehicle_client_mng.service.ColorService;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    private final ModelMapper modelMapper;
    private final ColorRepository colorRepository;
    private final String root = "Color";

    public ColorServiceImpl(ColorRepository colorRepository, ModelMapper modelMapper) {
        this.colorRepository = colorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response save(ColorDto colorDto) {
        Color color;
        color = modelMapper.map(colorDto, Color.class);
        color = colorRepository.save(color);
        if (color != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + "Has been Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, ColorDto colorDto) {
        Color color = colorRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (color != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            color = modelMapper.map(colorDto, Color.class);
            color = colorRepository.save(color);
            if (color != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " updated Successfully", null);
            }

            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Occurs");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getById(Long id) {
        Color color = colorRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (color != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            ColorDto productDto = modelMapper.map(color, ColorDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " retrieved Successfully", productDto);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response del(Long id) {
        Color color = colorRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (color != null) {
            color.setActiveStatus(ActiveStatus.DELETE.getValue());
            color = colorRepository.save(color);
            if (color != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Delete SucessFully", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getAll() {
        List<Color> colorList = colorRepository.list(ActiveStatus.ACTIVE.getValue());
        List<ColorDto> colorDtoList = this.getColors(colorList);
        if (colorDtoList.isEmpty() || colorDtoList == null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "There is No  Color", null);
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", colorDtoList);
    }

    private List<ColorDto> getColors(List<Color> colors) {
        List<ColorDto> colorDtoList = new ArrayList<>();
        colors.forEach(color -> {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            ColorDto colorDto = modelMapper.map(color, ColorDto.class);
            colorDtoList.add(colorDto);
        });
        return colorDtoList;
    }
}
