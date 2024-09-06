function mostrarFormulario(tipo) {
    const rightPanel = document.getElementById('rightPanel');
    let formulario = '';

    if (tipo === 'crear') {
        formulario = `
            <form id="encuestaPreguntaForm">
                <div class="form-group">
                    <label for="idCapitulo">Id del Capítulo:</label>
                    <input type="text" id="idCapitulo" placeholder="Id del capítulo" required>
                </div>
                <div class="form-group">
                    <label for="numeroPregunta">Número de la Pregunta:</label>
                    <input type="number" id="numeroPregunta" placeholder="Número de la pregunta" required>
                </div>
                <div class="form-group">
                    <label for="responseType">Tipo de Respuesta:</label>
                    <select id="responseType" required>
                        <option value="open">Respuesta Abierta</option>
                        <option value="multiple">Opción Múltiple</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="textoPregunta">Texto de la Pregunta:</label>
                    <input type="text" id="textoPregunta" placeholder="Texto de la pregunta" required>
                </div>
                <div class="form-group">
                    <label for="comentarioPregunta">Comentario de la Pregunta:</label>
                    <input type="text" id="comentarioPregunta" placeholder="Comentario de la pregunta" required>
                </div>
                <button type="submit" id="guardarCambios">Guardar Cambios</button>
            </form>
        `;
    } else if (tipo === 'actualizar') {
        formulario = `
            <form id="encuestaActualizarForm">
                <div class="form-group">
                    <label for="idPreguntaActualizar">Id de la Pregunta:</label>
                    <input type="number" id="idPreguntaActualizar" placeholder="Id de la pregunta" required>
                </div>
                <div class="form-group">
                    <label for="idCapituloActualizar">Id del Capítulo:</label>
                    <input type="number" id="idCapituloActualizar" placeholder="Id del capítulo" required>
                </div>
                <div class="form-group">
                    <label for="numeroPreguntaActualizar">Nuevo Número de la Pregunta:</label>
                    <input type="number" id="numeroPreguntaActualizar" placeholder="Nuevo número de la pregunta" required>
                </div>
                <div class="form-group">
                    <label for="responseType">Tipo de Respuesta:</label>
                    <select id="responseType" required>
                        <option value="open">Respuesta Abierta</option>
                        <option value="multiple">Opción Múltiple</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="textoPreguntaActualizar">Texto de la Pregunta:</label>
                    <input type="text" id="textoPreguntaActualizar" placeholder="Texto de la pregunta" required>
                </div>
                <div class="form-group">
                    <label for="comentarioPreguntaActualizar">Comentario de la Pregunta:</label>
                    <input type="text" id="comentarioPreguntaActualizar" placeholder="Comentario de la pregunta" required>
                </div>
                <button type="submit" id="guardarCambios">Guardar Cambios</button>
            </form>
        `;
    } else if (tipo === 'eliminar') {
        formulario = `
            <form id="CapituloEliminarForm">
                <div class="form-group">
                    <label for="idPreguntaEliminar">Id de la Pregunta a Eliminar:</label>
                    <input type="number" id="idPreguntaEliminar" placeholder="Id de la pregunta a eliminar" required>
                </div>
                <button type="submit" id="guardarCambios">Eliminar Pregunta</button>
            </form>
        `;
    }

    rightPanel.innerHTML = formulario;

    // Limpiar los eventos de submit previos para evitar conflictos
    const existingForm = document.querySelector('form');
    if (existingForm) {
        existingForm.removeEventListener('submit', handleFormSubmit);
    }

    // Agregar el evento de submit al formulario correcto
    function handleFormSubmit(e) {
        e.preventDefault();
        if (tipo === 'crear') {
            guardarEncuestaCrear();
        } else if (tipo === 'actualizar') {
            guardarEncuestaActualizar();
        } else if (tipo === 'eliminar') {
            guardarEncuestaEliminar();
        }
    }

    const form = document.getElementById(tipo === 'crear' ? 'encuestaPreguntaForm' :
                                        tipo === 'actualizar' ? 'encuestaActualizarForm' :
                                        'CapituloEliminarForm');
    if (form) {
        form.addEventListener('submit', handleFormSubmit);
    }
}
