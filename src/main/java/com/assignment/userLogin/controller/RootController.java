package com.assignment.userLogin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class RootController {

    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/welcome-message")
    public ResponseEntity<String> getFirstWelcomeMessage(Authentication authentication) {
        return ResponseEntity.ok("Welcome to our website: " + authentication.getName() + " with scope: " + authentication.getAuthorities());
    }

    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/manager-message")
    public ResponseEntity<String> getManagerData(Principal principal) {
        return ResponseEntity.ok("Manager::" + principal.getName());

    }

    @PreAuthorize("hasAuthority('SCOPE_WRITE')")
    @PostMapping("/admin-message")
    public ResponseEntity<String> getAdminData(@RequestParam("message") String message, Principal principal) {
        return ResponseEntity.ok("Admin::" + principal.getName() + " has this message: " + message);

    }
}
