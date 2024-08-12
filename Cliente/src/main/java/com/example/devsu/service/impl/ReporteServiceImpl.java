package com.example.devsu.service.impl;

import com.example.devsu.client.CuentaClient;
import com.example.devsu.client.MovimientoClient;
import com.example.devsu.dto.CuentaDTO;
import com.example.devsu.dto.MovimientoDTO;
import com.example.devsu.dto.ReporteDTO;
import com.example.devsu.entity.Cliente;
import com.example.devsu.exception.cliente.ClienteNotFoundException;
import com.example.devsu.exception.cuenta.CuentaNotFoundException;
import com.example.devsu.repository.ClienteRepository;
import com.example.devsu.service.ReporteService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {

    private final ClienteRepository clienteRepository;
    private final CuentaClient cuentaClient;
    private final MovimientoClient movimientoClient;

    @Override
    @SneakyThrows
    public  List<ReporteDTO> generarReportePorFecha(Integer clienteId, String fechaDesde, String fechaHasta) {

        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new ClienteNotFoundException("Cliente con id " + clienteId + " no existe"));

        List<CuentaDTO> cuentasPorClienteList = cuentaClient.getCuentasByCliente(cliente.getClienteId());

        if(cuentasPorClienteList.isEmpty()){
            throw new CuentaNotFoundException("El cliente no tiene cuentas registradas");
        }

        List<ReporteDTO> reportList = new ArrayList<>();

        cuentasPorClienteList.forEach((cuenta) -> {
            String numeroCuenta = cuenta.getNumeroCuenta();

            List<MovimientoDTO> movimientos = movimientoClient.getMovimientosByCuentaAndDateRange(numeroCuenta, fechaDesde, fechaHasta);
            if(!movimientos.isEmpty()){
                movimientos.forEach((movimiento) -> {
                    ReporteDTO reportDTO = new ReporteDTO();

                    reportDTO.setFecha(movimiento.getFecha());
                    reportDTO.setCliente(cliente.getNombre());
                    reportDTO.setNumeroCuenta(numeroCuenta);
                    reportDTO.setTipo(cuenta.getTipo());
                    reportDTO.setSaldoInicial(cuenta.getSaldoInicial());
                    reportDTO.setEstado(cuenta.isEstado());
                    reportDTO.setMovimiento(movimiento.getValor());
                    reportDTO.setSaldoDisponible(movimiento.getSaldo());

                    reportList.add(reportDTO);
                });
            }
        });

        return reportList;
    }
}
