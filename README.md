# 🌤️ WeatherApp - Consulta del Clima en Tiempo Real

Este proyecto es una aplicación **Java + Spring Boot + WebFlux** que consume la API de [OpenWeatherMap](https://openweathermap.org/api) para mostrar el estado del clima en tiempo real para una ciudad determinada. Está construido de forma reactiva usando `WebClient` y devuelve una respuesta personalizada con los datos más importantes del clima.

---

## 🚀 Características

- 🌎 Consulta el clima por ciudad (ej: Bogotá, Madrid, Tokyo).
- 🌡️ Devuelve temperatura, humedad, velocidad del viento y descripción del clima.
- ⚡ Programación reactiva con `WebClient` de Spring WebFlux.
- 🌐 Soporte para múltiples idiomas en la descripción (gracias al parámetro `lang`).
- 🔐 Uso de API Key externa segura con `@Value("${API_KEY}")`.

---

## 📥 Ejemplo de Uso:

### 🛠️ Petición de entrada con método POST (`RequestDTO`)

```json
{
  "city": "Bogotá",
  "lang": "es"
}
```

## 📥 Respuesta esperada:

```json
{
  "cityName": "Bogotá",
  "temperature": 18.5,
  "condition": "cielo claro",
  "humid": true or false,
  "cold": true or false,
  "windy": true or false,
  "windSpeed": 3.6
}
```
---

## ⚙️ Requisitos del Negocio

✅ El usuario debe ingresar el nombre de una ciudad.  
✅ La aplicación debe realizar la consulta del clima en tiempo real desde OpenWeather.  
✅ Solo deben mostrarse los datos relevantes: nombre de la ciudad, temperatura, descripción del clima (condition), humid = humedad > a 80%, cold = temperatura < 10 °C, windy = windSpeed > 10 m/s, y velocidad del viento m/s.  
✅ La descripción debe estar en el idioma solicitado por el usuario.  
✅ La aplicación debe ser no bloqueante (programación reactiva).  
✅ Se deben manejar errores de forma controlada si la ciudad no existe o si hay problemas con la API.

---

## 📚 Tecnologías Usadas

- Java 17
- Spring Boot 3
- Spring WebFlux
- WebClient
- Jackson (ObjectMapper)
- OpenWeather API
- Maven

---

## 👨‍💻 Autor

Desarrollado por [Brayan Díaz](https://github.com/BrayanDiaz89) 💻  
Apasionado por el desarrollo backend, las APIs y la programación limpia.

---

## 🌐 API Oficial de Clima

[OpenWeatherMap](https://openweathermap.org/api)



