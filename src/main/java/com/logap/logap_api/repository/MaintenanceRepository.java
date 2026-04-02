package com.logap.logap_api.repository;

import com.logap.logap_api.models.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {

    @Query(value = "SELECT * FROM manutencoes WHERE status = 'PENDENTE' ORDER BY data_inicio ASC LIMIT 5", nativeQuery = true)
    List<Maintenance> findUpcomingMaintenances();

    @Query(value = "SELECT COALESCE(SUM(custo_estimado), 0) FROM manutencoes " +
                   "WHERE EXTRACT(MONTH FROM data_inicio) = EXTRACT(MONTH FROM CURRENT_DATE) " +
                   "AND EXTRACT(YEAR FROM data_inicio) = EXTRACT(YEAR FROM CURRENT_DATE)", nativeQuery = true)
    BigDecimal getCurrentMonthFinancialProjection();

    @Query(value = "SELECT SUM(km_percorrida) FROM viagens", nativeQuery = true)
    BigDecimal getTotalDistanceTraveled();

    @Query(value = "SELECT v.placa, SUM(vi.km_percorrida) as total FROM veiculos v " +
                   "JOIN viagens vi ON v.id = vi.veiculo_id " +
                   "GROUP BY v.placa ORDER BY total DESC LIMIT 1", nativeQuery = true)
    Map<String, Object> getUsageRanking();

    @Query(value = "SELECT v.tipo, COUNT(vi.id) as total FROM veiculos v " +
                   "JOIN viagens vi ON v.id = vi.veiculo_id GROUP BY v.tipo", nativeQuery = true)
    List<Map<String, Object>> getVolumeByCategory();
}