function mostrarFormulario(tipo) {
    const rightPanel = document.getElementById('rightPanel');
    let formulario = '';

    if (tipo === 'crear') {
        formulario = `
            <form id="encuestaForm">
                <input type="text" id="nombreEncuesta" placeholder="Nombre de la encuesta" required>
                <input type="text" id="descripcionEncuesta" placeholder="Descripción de la encuesta" required>
                <button type="submit" id="guardarCambios">GUARDAR CAMBIOS</button>
            </form>
        `;
    } else if (tipo === 'actualizar') {
        formulario = `
            <form id="encuestaActualizarForm">
                <input type="number" id="idEncuestaActualizar" placeholder="Id de la encuesta" required>
                <input type="text" id="nombreEncuestaActualizar" placeholder="Nombre de la encuesta" required>
                <input type="text" id="descripcionEncuestaActualizar" placeholder="Nueva descripción" required>
                <button type="submit" id="guardarCambios">GUARDAR CAMBIOS</button>
            </form>
        `;
    } else if (tipo === 'eliminar') {
        formulario = `
            <form id="encuestaEliminarForm">
                <input type="text" id="nombreEncuestaEliminar" placeholder="Nombre de la encuesta a eliminar" required>
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

    const form = document.getElementById(tipo === 'crear' ? 'encuestaForm' :
                                        tipo === 'actualizar' ? 'encuestaActualizarForm' :
                                        'encuestaEliminarForm');
    if (form) {
        form.addEventListener('submit', handleFormSubmit);
    }
}