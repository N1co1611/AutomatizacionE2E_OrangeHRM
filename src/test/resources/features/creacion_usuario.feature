Feature: Gestión de empleados en OrangeHRM

  Como administrador de OrangeHRM
  Quiero agregar y validar un nuevo empleado
  Para asegurar que el sistema almacena correctamente la información

  Background:
    Given administrador accede al portal de OrangeHRM

  Scenario: Agregar y validar nuevo empleado
    When el navega al módulo PIM
    And agrega un nuevo empleado con 2 nombres y un apellido
    And sube una foto de perfil para el empleado
    And navega al módulo Directory
    And realiza una búsqueda por nombre del empleado creado
    Then valida que la información básica del empleado se haya almacenado correctamente