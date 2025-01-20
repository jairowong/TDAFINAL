package GestionPago.MSPago.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import GestionPago.MSPago.config.UtilsProperties;
import GestionPago.MSPago.dto.PagoDTO;
import GestionPago.MSPago.model.PagoModel;
import GestionPago.MSPago.service.PagoService;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/pago")
public class PagoController {
	private Logger logger = LoggerFactory.getLogger(PagoController.class);

	@Autowired
	private PagoService alumnoService;

	@Autowired
	private UtilsProperties prop;	

	@GetMapping("/list")
	public ResponseEntity<?> getAll() {
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<PagoModel> lista = alumnoService.findAll();

			List<PagoDTO> listaDTO = lista.stream().map(x -> {
				ModelMapper m = new ModelMapper();
				return m.map(x, PagoDTO.class);
			}).collect(Collectors.toList());

			salida.put("data", listaDTO);

			logger.info("GET[Response] {}", listaDTO);
			return new ResponseEntity<>(salida, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			salida.put("msg", prop.MS_ERROR_RECUPERAR);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(salida);
		}
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			logger.info("GET[Request] getById {} ", id);

			ModelMapper m = new ModelMapper();
			PagoModel obj = alumnoService.findById(id);

			if (obj != null) {
				PagoDTO dto = m.map(alumnoService.findById(id), PagoDTO.class);
				
				logger.info("GET[Response] {}", dto);
				salida.put("data", dto);
				return new ResponseEntity<>(salida, HttpStatus.OK);
			} else {
				salida.put("msg", prop.MS_NO_ENCONTRADO);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(salida);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			salida.put("msg", prop.MS_ERROR_RECUPERAR);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(salida);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody PagoDTO request) {
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			logger.info("POST[Request] create {} ", request);

			ModelMapper m = new ModelMapper();
			PagoModel obj = m.map(request, PagoModel.class);
			obj.setFecha(new Date());
			salida.put("msg", prop.MS_EXITO_GUARDAR);
			salida.put("data", alumnoService.add(obj));

			return ResponseEntity.status(HttpStatus.OK).body(salida);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			salida.put("msg", prop.MS_EROR_PROCESAR);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(salida);
		}
	}
}
