package com.example.mytest

import androidx.compose.runtime.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ServerClient {
    // Fonction suspendue pour effectuer des opérations réseau
    suspend fun fetchDataFromServer(): String {
        return withContext(Dispatchers.IO) {
            val url = URL("http://localhost:8080/person")
            val connection = url.openConnection() as HttpURLConnection

            try {
                connection.requestMethod = "GET"
                // Configurer la connexion (ajouter des en-têtes, des données, etc.)

                val responseCode = connection.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val inputStream = connection.inputStream
                    val reader = BufferedReader(InputStrepamReader(inputStream))
                    val stringBuilder = StringBuilder()
                    var line: String?

                    while (reader.readLine().also { line = it } != null) {
                        stringBuilder.append(line)
                    }

                    // Convertir la réponse en chaîne
                    val responseData = stringBuilder.toString()
                    return@withContext responseData
                } else {
                    // Gérer les erreurs de connexion
                    return@withContext "Erreur de connexion : ${connection.responseMessage}"
                }
            } finally {
                connection.disconnect()
            }
        }
    }
}