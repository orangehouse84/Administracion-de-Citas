# Administracion-de-Citas
El programa permite gestionar doctores, pacientes y citas médicas, almacenando la información en archivos CSV.
# Sistema de Administración de Citas Médicas

Este programa en Java permite gestionar doctores, pacientes y citas médicas, almacenando la información en archivos CSV.

## Funcionalidades

* **Dar de alta doctores:** Agrega nuevos doctores al sistema con su ID, nombre y especialidad.
* **Dar de alta pacientes:** Agrega nuevos pacientes al sistema con su ID y nombre.
* **Crear citas:** Crea nuevas citas médicas, asociándolas a un doctor y un paciente, con fecha, hora y motivo.
* **Almacenamiento en CSV:** Guarda la información de doctores, pacientes y citas en archivos CSV ("doctores.csv", "pacientes.csv", "citas.csv").

## Estructura del Proyecto

* **`Doctor.java`:** Clase que representa a un doctor.
* **`Paciente.java`:** Clase que representa a un paciente.
* **`Cita.java`:** Clase que representa una cita médica.
* **`GestorArchivo.java`:** Clase utilitaria para guardar y cargar datos de archivos CSV.
* **`InterfazGrafica.java`:** Clase que implementa la interfaz de línea de comandos.
* **`Citasconsultorio.java`:** Clase principal que inicia la aplicación.
