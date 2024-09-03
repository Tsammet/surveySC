document.addEventListener('DOMContentLoaded', () => {
    mostrarEncuestas();
});

function mostrarEncuestas() {
    fetch('http://localhost:8080/surveyapi/allsurvey')
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // Suponiendo que el backend devuelve un JSON
    })
    .then(data => {
        console.log('Datos recibidos:', data);  // Verifica los datos recibidos

        const encuestas = data.content || data; 

        if (!Array.isArray(encuestas)) {
            throw new Error('La estructura de datos no es un array.');
        }

        const encuestaList = document.getElementById('content');

        let tableHTML = `
            <table>
                <tr>
                    <th>ID encuesta</th>
                    <th>Nombre encuesta</th>
                    <th>Descripción</th>
                    <th>Acción</th>
                </tr>
        `;

        encuestas.forEach(encuesta => {
            tableHTML += `
                <tr>
                    <td>${encuesta.id}</td>
                    <td>${encuesta.name}</td>
                    <td>${encuesta.description}</td>
                    <td><button onclick="verCapitulos(${"#"})">Responder</button></td>
                </tr>
            `;
        });

        tableHTML += '</table>';
        encuestaList.innerHTML = tableHTML;
    })
    .catch(error => {
        console.error('Error al intentar obtener las encuestas:', error);
        alert('Error al intentar obtener las encuestas: ' + error.message);
    });
}

