package com.logap.logap_api.controllers;

import com.logap.logap_api.dto.MaintenanceRequest;
import com.logap.logap_api.models.*;
import com.logap.logap_api.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/maintenance")
@CrossOrigin(origins = {"http://localhost:5173", "https://sua-url-producao.com"})
public class MaintenanceController {

    private final MaintenanceRepository repository;

    @Autowired
    public MaintenanceController(MaintenanceRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/")
    public ResponseEntity<Maintenance> agendar(@RequestBody MaintenanceRequest request) {
        Maintenance maintenance = new Maintenance();
        maintenance.setVeiculoId(request.getVeiculoId());
        maintenance.setDataInicio(request.getDataInicio());
        maintenance.setDataFinalizacao(request.getDataFinalizacao());
        maintenance.setTipoServico(request.getTipoServico());
        maintenance.setCustoEstimado(request.getCustoEstimado());
        maintenance.setStatus(request.getStatus());
        
        return ResponseEntity.ok(repository.save(maintenance));
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getDashboard() {
        return ResponseEntity.ok(Map.of(
            "totalKilometersTraveled", repository.getTotalDistanceTraveled(),
            "volumeByCategory", repository.getVolumeByCategory(),
            "maintenanceSchedule", repository.findUpcomingMaintenances(),
            "usageRanking", repository.getUsageRanking(),
            "projecaoFinanceira", repository.getCurrentMonthFinancialProjection()
        ));
    }
}