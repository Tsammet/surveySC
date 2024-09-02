document.addEventListener('DOMContentLoaded', () => {
    // Obtén el parámetro surveyId de la URL
    const urlParams = new URLSearchParams(window.location.search);
    const chapterId = urlParams.get('chapterId');

    if (chapterId) {
        mostrarPreguntas(chapterId);
    } else {
        alert('ID de capitulo no encontrado');
    }
});

function mostrarPreguntas(chapterId) {
    fetch(`http://localhost:8080/questionapi?chapterId=${chapterId}`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // Suponiendo que el backend devuelve un JSON
    })
    .then(data => {
        console.log('Preguntas recibidos:', data);  // Verifica los datos recibidos

        const preguntas = data.content || data;

        if (!Array.isArray(preguntas)) {
            throw new Error('La estructura de datos no es un array.');
        }

        const questionList = document.getElementById('content');

        let tableHTML = `
            <table>
                <tr>
                    <th>ID Pregunta</th>
                    <th>Nombre Capitulo</th>
                    <th>Numero Pregunta</th>
                    <th>Tipo Pregunta</th>
                    <th>Texto Pregunta</th>
                    <th>Comentario Pregunta</th>
                </tr>
        `;

        preguntas.forEach(pregunta => {
            tableHTML += `
                <tr>
                    <td>${pregunta.id}</td>
                    <td>${pregunta.chapters.chapterTitle}</td>
                    <td>${pregunta.questionNumber}</td>
                    <td>${pregunta.responseType}</td>
                    <td>${pregunta.questionText}</td>
                    <td>${pregunta.commentQuestion}</td>
                </tr>
            `;
        });

        tableHTML += '</table>';
        questionList    .innerHTML = tableHTML;
    })
    .catch(error => {
        console.error('Error al intentar obtener los capítulos:', error);
        alert('Error al intentar obtener los capítulos: ' + error.message);
    });
}

function goBack() {
    window.history.back();
}