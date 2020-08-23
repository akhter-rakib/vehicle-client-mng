package com.vhaibrother.vehicle_client_mng.service.impl;

import com.vhaibrother.vehicle_client_mng.dto.ClientDto;
import com.vhaibrother.vehicle_client_mng.dto.ProfessionDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;
import com.vhaibrother.vehicle_client_mng.entity.Client;
import com.vhaibrother.vehicle_client_mng.entity.Profession;
import com.vhaibrother.vehicle_client_mng.enums.ActiveStatus;
import com.vhaibrother.vehicle_client_mng.repository.ClientRepository;
import com.vhaibrother.vehicle_client_mng.service.ClientService;
import com.vhaibrother.vehicle_client_mng.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ModelMapper modelMapper;
    private final ClientRepository clientRepository;
    private final String root = "Client";

    public ClientServiceImpl(ModelMapper modelMapper, ClientRepository clientRepository) {
        this.modelMapper = modelMapper;
        this.clientRepository = clientRepository;
    }


    @Override
    public Response save(ClientDto clientDto) {
        Client client;
        client = modelMapper.map(clientDto, Client.class);
        client = clientRepository.save(client);
        if(client != null){
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root+"has been Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, ClientDto clientDto) {
        Client client;
        client = clientRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if(client != null){
            client = modelMapper.map(clientDto, Client.class);
            client = clientRepository.save(client);
            if(client != null){
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "has been Updated", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + "is not Found");
    }

    @Override
    public Response getById(Long id) {
        Client client;
        client = clientRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (client != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            ClientDto clientDto = modelMapper.map(client, ClientDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", clientDto);
        }
        return null;
    }

    @Override
    public Response del(Long id) {
        Client client;
        client = clientRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (client != null) {
            client.setActiveStatus(ActiveStatus.DELETE.getValue());
            client = clientRepository.save(client);
            if (client != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Delete SucessFully", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getAll() {
        List<Client> clientList = clientRepository.list(ActiveStatus.ACTIVE.getValue());
        List<ClientDto> clientDtoList = this.getClients(clientList);
        if (clientDtoList.isEmpty() || clientDtoList == null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "There is No" + root, null);
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", clientDtoList);
    }
    private List<ClientDto> getClients(List<Client> clients) {
        List<ClientDto> clientDtoList = new ArrayList<>();
        clients.forEach(client -> {
            ClientDto clientDto = modelMapper.map(client, ClientDto.class);
            clientDtoList.add(clientDto);
        });
        return clientDtoList;
    }
}
