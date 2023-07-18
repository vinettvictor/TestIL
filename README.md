# TestIL

## Requerimientos
- java 17
- Se utilizó Maven como Gestor de dependencias.

## 1. Repositorio de Datos
- El banco de datos utilizado es H2 y se esta exponiendo en el puerto 8080
- el path es el siguiente: http://localhost:8080/h2
- la base de datos es : db_adm
- usuario: sa
- password:                         -- No tiene password
- Estos datos se pueden validar en el archivo properties del proyecto. 

## 2. Como probar
Clonar repositorio y una vez Levantado, mediante Postman y el método GET 
- Utiliza el siguiente path: http://localhost:8080/createUser , para la creación del usuario.
- Utiliza el siguiente path: http://localhost:8080/getUsers , para obtener los usuarios creados.

- el correo debe seguir formato: aaaaaa@gmail.com
- la contraseña debe contener entre 4 y 8 carácteres, minusculas,mayusculas y números.

- Para el body se utiliza como el siguiente JSON Ejemplo:
```json
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
```
