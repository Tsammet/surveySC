function mostrarFormulario(tipo) {
    const rightPanel = document.getElementById('rightPanel');
    let formulario = '';

    if (tipo === 'crear') {
        formulario = `
            <form id="encuestaPreguntaForm">
                <input type="text" id="idCapitulo" placeholder="Id del capítulo" required>
                <input type="number" id="numeroPregunta" placeholder="Número de la pregunta" required>
                <input type="text" id="responseType" placeholder="TipoPregunta" required>
                <input type="text" id="textoPregunta" placeholder="Texto de la pregunta" required>
                <input type="text" id="comentarioPregunta" placeholder="Comentario de la pregunta" required>
                <button type="submit" id="guardarCambios">GUARDAR CAMBIOS</button>
            </form>
        `;
    } else if (tipo === 'actualizar') {
        formulario = `
            <form id="encuestaActualizarForm">
                <input type="number" id="idPreguntaActualizar" placeholder="Id de la pregunta" required>
                <input type="number" id="idCapituloActualizar" placeholder="Id del capitulo" required>
                <input type="number" id="numeroPreguntaActualizar" placeholder="Nuevo numero de la pregunta" required>
                <input type="text" id="responseType" placeholder="Tipo Pregunta" required>
                <input type="text" id="textoPreguntaActualizar" placeholder="texto de la pregunta" required>
                <input type="text" id="comentarioPreguntaActualizar" placeholder="Comentario de la pregunta" required>
                <button type="submit" id="guardarCambios">GUARDAR CAMBIOS</button>
            </form>
        `;
    } else if (tipo === 'eliminar') {
        formulario = `
            <form id="CapituloEliminarForm">
                <input type="number" id="idPreguntaEliminar" placeholder="Id de la pregunta a eliminar" required>
                <button type="submit" id="guardarCambios">GUARDAR CAMBIOS</button>
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