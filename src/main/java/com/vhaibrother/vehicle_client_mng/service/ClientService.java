package com.vhaibrother.vehicle_client_mng.service;
import com.vhaibrother.vehicle_client_mng.dto.ClientDto;
import com.vhaibrother.vehicle_client_mng.dto.Response;

public interface ClientService {
    public Response save(ClientDto clientDto);

    public Response update(Long id, ClientDto clientDto);

    public Response getById(Long id);

    public Response del(Long id);

    public Response getAll();
}
