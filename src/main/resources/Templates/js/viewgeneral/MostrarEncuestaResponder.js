document.addEventListener('DOMContentLoaded', () => {
    const urlParams = new URLSearchParams(window.location.search);
    const surveyId = urlParams.get('surveyId');

    if (surveyId) {
        cargarDatosEncuesta(surveyId);
        mostrarCapitulos(surveyId);
    } else {
        alert('ID de encuesta no encontrado');
    }
});

function cargarDatosEncuesta(surveyId) {
    fetch(`http://localhost:8080/surveyapi/${surveyId}`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('Datos de la encuesta:', data);

        // Contenedor para mostrar la encuesta
        const encuestaContainer = document.getElementById('encuesta-container');
        encuestaContainer.innerHTML = `
            <div class="info-item">
                <span class="info-label">ID Encuesta:</span>
                <span class="info-value">${data.id || 'No disponible'}</span>
            </div>
            <div class="info-item">
                <span class="info-label">Nombre Encuesta:</span>
                <span class="info-value">${data.name || 'No disponible'}</span>
            </div>
            <div class="info-item">
                <span class="info-label">Descripción Encuesta:</span>
                <span class="info-value">${data.description || 'No disponible'}</span>
            </div>
        `;
    })
    .catch(error => {
        console.error('Error al intentar obtener los datos de la encuesta:', error);
        alert('Error al intentar obtener los datos de la encuesta: ' + error.message);
    });
}

function mostrarCapitulos(surveyId) {
    fetch(`http://localhost:8080/chapterapi?surveyId=${surveyId}`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('Capítulos recibidos:', data);

        const capitulos = data.content || data;

        if (!Array.isArray(capitulos)) {
            throw new Error('La estructura de datos no es un array.');
        }

        // Contenedor para mostrar capítulos
        const chapterContainer = document.getElementById('chapter-container');
        chapterContainer.innerHTML = '';

        capitulos.forEach(capitulo => {
            const chapterDiv = document.createElement('div');
            chapterDiv.className = 'chapter-item';
            chapterDiv.innerHTML = `
                <div><span class="chapter-label">ID capítulo:</span> ${capitulo.id}</div>
                <div><span class="chapter-label">Número capítulo:</span> ${capitulo.chapterNumber}</div>
                <div><span class="chapter-label">Título capítulo:</span> ${capitulo.chapterTitle}</div>
                <button class="view-questions" onclick="verPreguntas(${capitulo.id})">Ver Preguntas</button>
            `;
            chapterContainer.appendChild(chapterDiv);
        });
    })
    .catch(error => {
        console.error('Error al intentar obtener los capítulos:', error);
        alert('Error al intentar obtener los capítulos: ' + error.message);
    });
}

function verPreguntas(chapterId) {
    window.location.href = `verPreguntas.html?chapterId=${chapterId}`;
}

document.querySelector('.back-button').addEventListener('click', () => {
    window.history.back();
});
