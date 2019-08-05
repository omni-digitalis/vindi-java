package br.com.vindi.models;

import java.time.LocalDateTime;
import java.util.List;

public final class Client {

    private Long id;

    private String name;

    private String email;

    private String registryCode;

    private String code;

    private String notes;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String metadata;

    private Address address;

    private List<Phone> phones;


}
