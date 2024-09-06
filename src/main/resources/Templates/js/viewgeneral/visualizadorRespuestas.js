document.addEventListener('DOMContentLoaded', () => {
    // Obtén el parámetro surveyId de la URL
    const urlParams = new URLSearchParams(window.location.search);
    const surveyId = urlParams.get('surveyId');

    if (surveyId) {
        mostrarCapitulos(surveyId);
    } else {
        alert('ID de encuesta no encontrado');
    }
});

function mostrarCapitulos(surveyId) {
    fetch(`http://localhost:8080/chapterapi?surveyId=${surveyId}`)
    // fetch(`http://localhost:8080/chapterapi/allquestion`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // Suponiendo que el backend devuelve un JSON
    })
    .then(data => {
        console.log('Capítulos recibidos:', data);  // Verifica los datos recibidos

        const capitulos = data.content || data;

        if (!Array.isArray(capitulos)) {
            throw new Error('La estructura de datos no es un array.');
        }

        const chapterList = document.getElementById('content');

        let tableHTML = `
            <table>
                <tr>
                    <th>ID capítulo</th>
                    <th>Número capítulo</th>
                    <th>Título capítulo</th>
                </tr>
        `;

        capitulos.forEach(capitulo => {
            tableHTML += `
                <tr>
                    <td>${capitulo.id}</td>
                    <td>${capitulo.chapterNumber}</td>
                    <td>${capitulo.chapterTitle}</td>
                    <td><button onclick="verCapitulos(${capitulo.id})">Ver Preguntas</button></td>

                </tr>
            `;
        });
// 
        tableHTML += '</table>';
        chapterList.innerHTML = tableHTML;
    })
    .catch(error => {
        console.error('Error al intentar obtener los capítulos:', error);
        alert('Error al intentar obtener los capítulos: ' + error.message);
    });
}

function verCapitulos(encuestaId) {
    window.location.href = `verPreguntas.html?chapterId=${encuestaId}`;
}

function goBack() {
    window.history.back();
}