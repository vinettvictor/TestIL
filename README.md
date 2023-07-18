# TestIL

## 1. Repositorio de Datos
El banco de datos utilizado es H2 y se esta exponiendo en el puerto 8080
el path es el siguiente: http://localhost:8080/h2

## 2. Como probar
Clonar repositorio y una vez Levantado, mediante Postman y el método GET 
Utiliza el siguiente path: http://localhost:8080/createUser

- el correo debe seguir formato: aaaaaa@gmail.com
- la contraseña debe contener entre 4 y 8 carácteres, minuculas,mayusculas y números.

El body sería como el siguiente JSON Ejemplo:
{
"name": "Victor Vinett",
"email": "vinett@gmail.com",
"password": "Vinett12",
"phone": [
        {
        "number": "82281179",
        "citycode": "1",
        "contrycode": "57"
        }
]
}
