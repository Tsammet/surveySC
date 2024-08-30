document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('encuestaForm');
    const agregarCapituloBtn = document.getElementById('agregarCapitulo');
    const capitulosContainer = document.getElementById('capitulos');
    let capituloCount = 0;

    agregarCapituloBtn.addEventListener('click', function() {
        capituloCount++;
        const capituloDiv = document.createElement('div');
        capituloDiv.className = 'capitulo';
        capituloDiv.innerHTML = `
            <h3>Capítulo ${capituloCount}</h3>
            <div class="form-group">
                <label for="numeroCapitulo${capituloCount}">Número del Capítulo:</label>
                <input type="text" id="numeroCapitulo${capituloCount}" required>
            </div>
            <div class="form-group">
                <label for="tituloCapitulo${capituloCount}">Título del Capítulo:</label>
                <input type="text" id="tituloCapitulo${capituloCount}" required>
            </div>
            <button type="button" class="agregarPregunta">+ Agregar Pregunta</button>
            <div class="preguntas"></div>
        `;
        capitulosContainer.appendChild(capituloDiv);

        const agregarPreguntaBtn = capituloDiv.querySelector('.agregarPregunta');
        const preguntasContainer = capituloDiv.querySelector('.preguntas');
        let preguntaCount = 0;

        agregarPreguntaBtn.addEventListener('click', function() {
            preguntaCount++;
            const preguntaDiv = document.createElement('div');
            preguntaDiv.className = 'pregunta';
            preguntaDiv.innerHTML = `
                <div class="form-group">
                    <label for="numeroPregunta${capituloCount}_${preguntaCount}">Número de la Pregunta:</label>
                    <input type="text" id="numeroPregunta${capituloCount}_${preguntaCount}" required>
                </div>
                <div class="form-group">
                    <label for="tipoPregunta${capituloCount}_${preguntaCount}">Tipo de Respuesta:</label>
                    <select id="tipoPregunta${capituloCount}_${preguntaCount}" required>
                        <option value="">Seleccione un tipo</option>
                        <option value="multiple">Opción múltiple</option>
                        <option value="abierta">Respuesta abierta</option>
                        <option value="escala">Escala</option>
                    </select>
                </div>
            `;
            preguntasContainer.appendChild(preguntaDiv);
        });
    });

    form.addEventListener('submit', function(e) {
        e.preventDefault();
        const encuesta = {
            nombre: document.getElementById('nombreEncuesta').value,
            descripcion: document.getElementById('descripcionEncuesta').value,
            capitulos: []
        };

        document.querySelectorAll('.capitulo').forEach((capituloEl, capituloIndex) => {
            const capitulo = {
                numero: document.getElementById(`numeroCapitulo${capituloIndex + 1}`).value,
                titulo: document.getElementById(`tituloCapitulo${capituloIndex + 1}`).value,
                preguntas: []
            };

            capituloEl.querySelectorAll('.pregunta').forEach((preguntaEl, preguntaIndex) => {
                capitulo.preguntas.push({
                    numero: document.getElementById(`numeroPregunta${capituloIndex + 1}_${preguntaIndex + 1}`).value,
                    tipo: document.getElementById(`tipoPregunta${capituloIndex + 1}_${preguntaIndex + 1}`).value
                });
            });

            encuesta.capitulos.push(capitulo);
        });

        console.log('Encuesta guardada:', encuesta);
        // Aquí iría el código para enviar la encuesta al servidor
        alert('Encuesta guardada con éxito!');
    });
});