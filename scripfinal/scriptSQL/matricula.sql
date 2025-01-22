CREATE TABLE matricula (
    id INT IDENTITY(1,1) PRIMARY KEY,  -- Clave primaria con autoincremento
    idalumno NVARCHAR(50) NOT NULL,   -- Identificador del alumno
    mat_fecha DATE NOT NULL,          -- Fecha de la matrícula
    mat_estado NVARCHAR(20) NOT NULL, -- Estado de la matrícula
    mat_grado NVARCHAR(20) NOT NULL,  -- Grado de la matrícula
    mat_seccion NVARCHAR(10) NOT NULL, -- Sección de la matrícula
    tipo_matricula INT NOT NULL       -- Tipo de matrícula
);

INSERT INTO matricula (idalumno, mat_fecha, mat_estado, mat_grado, mat_seccion, tipo_matricula)
VALUES 
('A001', '2025-01-20', 'Activo', 'Primero', 'A', 1),
('A002', '2025-01-21', 'Activo', 'Segundo', 'B', 2),
('A003', '2025-01-22', 'Inactivo', 'Tercero', 'C', 1),
('A004', '2025-01-23', 'Activo', 'Cuarto', 'D', 3),
('A005', '2025-01-24', 'Inactivo', 'Quinto', 'E', 2);

SELECT  * FROM  matricula;