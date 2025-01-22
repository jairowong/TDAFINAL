CREATE TABLE DetalleMatricula (


    iddetalle_matricula INT PRIMARY KEY IDENTITY(1,1), -- Identificador único, autoincremental
    idalumno INT NOT NULL,                            -- Identificador del alumno
    idmatricula INT NOT NULL,                         -- Identificador de la matrícula
    grado NVARCHAR(50) NOT NULL,                     -- Grado del alumno
    seccion NVARCHAR(50) NOT NULL,                   -- Sección del alumno
    curso NVARCHAR(100) NOT NULL,                    -- Curso asignado
    periodo NVARCHAR(20) NOT NULL                    -- Periodo académico
);

INSERT INTO DetalleMatricula (idalumno, idmatricula, grado, seccion, curso, periodo)
VALUES 
(1, 101, 'Primero', 'A', 'Matemáticas', '2025'),
(2, 102, 'Segundo', 'B', 'Ciencias', '2025'),
(3, 103, 'Tercero', 'A', 'Historia', '2025'),
(4, 104, 'Cuarto', 'C', 'Inglés', '2025'),
(5, 105, 'Quinto', 'B', 'Computación', '2025');

SELECT * from DetalleMatricula;

DROP TABLE detallem