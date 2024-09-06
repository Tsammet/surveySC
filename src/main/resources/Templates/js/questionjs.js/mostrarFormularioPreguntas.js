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
                <!-- Campos de actualización aquí -->
            </form>
        `;
    } else if (tipo === 'eliminar') {
        formulario = `
            <form id="CapituloEliminarForm">
                <!-- Campos de eliminación aquí -->
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