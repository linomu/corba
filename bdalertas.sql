CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `numHabitacion` int(22) UNIQUE NOT NULL ,
  `nombresPaciente` varchar(30),
  `apellidosPaciente` varchar(30),
  `fechaNac` DATE NOT NULL,
  PRIMARY KEY (idPaciente, numHabitacion)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `alertas` (
  `idAlertas` int(11) NOT NULL AUTO_INCREMENT,
  `numHabitacion` int(22) NOT NULL,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (idAlertas, numHabitacion),
  FOREIGN KEY (numHabitacion)
        REFERENCES paciente (idPaciente)
        ON UPDATE RESTRICT ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*
INSERT INTO empleado(nombresEmpleado, apellidosEmpleado, salarioEmpleado) values('catalina','sanchez',1000);
INSERT INTO empleado(nombresEmpleado, apellidosEmpleado, salarioEmpleado) values('juan','rodriguez',2000);
INSERT INTO empleado(nombresEmpleado, apellidosEmpleado, salarioEmpleado) values('catalina','perez',3000);
*/
