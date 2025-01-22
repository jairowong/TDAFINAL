SET IDENTITY_INSERT solicitud ON;

-- Insertar los datos
INSERT INTO solicitud (IdAlumno, fecha_solicitud, estado)
VALUES 

(50, '2025-01-24', 'Aprobado'),
(51, '2025-01-12', 'Rechazado');

SET IDENTITY_INSERT solicitud OFF;

SELECT * FROM solicitud;