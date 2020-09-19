package com.vhaibrother.vehicle_client_mng.service.impl;

import com.vhaibrother.vehicle_client_mng.dto.ProfessionDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.entity.Color;
import com.vhaibrother.vehicle_client_mng.entity.Profession;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import com.vhaibrother.vehicle_client_mng.repository.ProfessionRepository;
import com.vhaibrother.vehicle_client_mng.service.ProfessionService;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    private final ModelMapper modelMapper;
    private final ProfessionRepository professionRepository;
    private final String root = "Profession";

    public ProfessionServiceImpl(ModelMapper modelMapper, ProfessionRepository professionRepository) {
        this.modelMapper = modelMapper;
        this.professionRepository = professionRepository;
    }

    @Override
    public Response save(ProfessionDto professionDto) {
        Profession professionName = getProfessionName(professionDto);
        if (professionName != null) {
            return ResponseBuilder.getFailureResponse(HttpStatus.IM_USED, "This" + root + "Already Created");
        }
        Profession profession;
        profession = modelMapper.map(professionDto, Profession.class);
        profession = professionRepository.save(profession);
        if (profession != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + " Has been Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, ProfessionDto professionDto) {
        Profession professionName = getProfessionName(professionDto);
        if (professionName != null) {
            return ResponseBuilder.getFailureResponse(HttpStatus.IM_USED, "This" + root + "Already Created");
        }
        Profession profession;
        profession = professionRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (profession != null) {
            profession = modelMapper.map(professionDto, Profession.class);
            profession = professionRepository.save(profession);
            if (profession != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " Has been Updated", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + "Is not Found");
    }

    @Override
    public Response getById(Long id) {
        Profession profession;
        profession = professionRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (profession != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            ProfessionDto professionDto = modelMapper.map(profession, ProfessionDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", professionDto);
        }
        return null;
    }

    @Override
    public Response del(Long id) {
        Profession profession;
        profession = professionRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (profession != null) {
            profession.setActiveStatus(ActiveStatus.DELETE.getValue());
            profession = professionRepository.save(profession);
            if (profession != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Delete SucessFully", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getAll() {
        List<Profession> professionList = professionRepository.list(ActiveStatus.ACTIVE.getValue());
        List<ProfessionDto> professionDtoList = this.getProfessions(professionList);
        if (professionDtoList.isEmpty() || professionDtoList == null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "There is No" + root, null);
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", professionDtoList);
    }

    private List<ProfessionDto> getProfessions(List<Profession> professions) {
        List<ProfessionDto> professionDtoList = new ArrayList<>();
        professions.forEach(profession -> {
            ProfessionDto professionDto = modelMapper.map(profession, ProfessionDto.class);
            professionDtoList.add(professionDto);
        });
        return professionDtoList;
    }

    private Profession getProfessionName(ProfessionDto professionDto) {
        Profession professionName = professionRepository.findByProfessionName(professionDto.getProfessionName());
        return professionName;
    }

}
