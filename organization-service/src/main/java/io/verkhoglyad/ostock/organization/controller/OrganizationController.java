package io.verkhoglyad.ostock.organization.controller;

import io.verkhoglyad.ostock.organization.model.Organization;
import io.verkhoglyad.ostock.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService service;

    @GetMapping("/{organizationId}")
    public Organization details(@PathVariable("organizationId") String organizationId) {
        return service.findById(organizationId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organization create(@RequestBody Organization organization) {
        return service.create(organization);
    }

    @PutMapping("/{organizationId}")
    public Organization update(@PathVariable("organizationId") String id, @RequestBody Organization organization) {
        return service.update(organization);
    }

    @DeleteMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id, @RequestBody Organization organization) {
        service.delete(organization);
    }
}
