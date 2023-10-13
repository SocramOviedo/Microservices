# Microservices


-- Servicio desplegado en git hub

https://github.com/SocramOviedo/Microservicios


------- Clientes -------

------- Todas los clientes GET

http://localhost:8080/clientes

------- Obtener por id de cliente (GET) o actualizar (PUT)

http://localhost:8080/clientes/1

------- Crear cliente POST

http://localhost:8080/clientes

{
    "contrasena": "Hola",
    "estado": "ACTIVO"
}

------- Personas -------

------- Todas las personas GET

http://localhost:8080/personas

------- Obtener por id de cliente (GET) o actualizar (PUT)

http://localhost:8080/personas/1

------- Crear personas POST

http://localhost:8080/personas

{
    "nombre": "Jose Lema",
    "genero": "Masculino",
    "edad": 28,
    "identificacion": "152456789",
    "direccion": "Otavalo sn y principal",
    "telefono": "098254785",
	"estado": "ACTIVO"
}

{
    "nombre": "Marianela Montalvo",
    "genero": "Femenino",
    "edad": 35,
    "identificacion": "123456789",
    "direccion": "Amazonas y NNUU",
    "telefono": "097548965",
	"estado": "ACTIVO"
}

{
    "nombre": "Juan Osorio",
    "genero": "Masculino",
    "edad": 25,
    "identificacion": "175456789",
    "direccion": "13 junio y Equinoccial",
    "telefono": "098874587",
	"estado": "ACTIVO"
}

------- Cuentas -------

------- Todas las cuentas

http://localhost:8080/cuentas

------- Obtener por id de cuenta (GET) o actualizar (PUT)

http://localhost:8080/cuentas/1

 "id": 1,
    "numeroCuenta": "225487",
    "saldo": 100.0,
    "tipoCuenta": "Corriente",
    "estado": "ACTIVA",
    "cliente": "Marianela Montalvo"

------- Crear cuentas POST

http://localhost:8080/cuentas

{
  "saldo": 2000.0,
  "numeroCuenta": 478758,
  "tipoCuenta": "Ahorroñs",
  "estado": "Activa",
  "cliente": "Jose Lema" 
}
{
  "saldo": 100.0,
  "numeroCuenta": 225487,
  "tipoCuenta": "Corriente",
  "estado": "ACTIVA",
  "cliente": "Marianela Montalvo" 
}
{
  "saldo": 0.0,
  "numeroCuenta": 495878,
  "tipoCuenta": "Ahorros",
  "estado": "ACTIVA",
  "cliente": "Juan Osorio" 
}
{
  "saldo": 540.0,
  "numeroCuenta": 496825,
  "tipoCuenta": "Ahorros",
  "estado": "ACTIVA",
  "cliente": "Marianela Montalvo" 
}

------- Movimientos -------

------- Todos los movimientos

http://localhost:8080/movimientos

------- Obtener por id de movimiento (GET) o actualizar (PUT)

http://localhost:8080/movimientos/1


------- Crear movimientos POST

http://localhost:8080/movimientos

 {
  "cuenta": {
    "id": 1
  },
  "fecha": "2023-10-01",
  "tipoMovimiento": "INGRESO",
  "valor": 100.0,
  "saldo": 500.0,
  "estado": "ACTIVO"
}

------- Con este metodo (POST) se realiza la validacion de saldo insuficiente y se verifica si exsite la cuenta

http://localhost:8080/movimientos/registrar

{
  "cuenta": {
    "id": 1
  },
  "fecha": "2023-10-01",
  "tipoMovimiento": "EGRESO",
  "valor": 500.0,
  "saldo": 200.0,
   "estado": "ACTIVO"
}
