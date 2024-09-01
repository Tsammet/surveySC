function mostrarFormulario(tipo) {
    const rightPanel = document.getElementById('rightPanel');
    let formulario = '';

    if (tipo === 'crear') {
        formulario = `
            <form id="encuestaCapituloForm">
                <input type="text" id="idEncuesta" placeholder="Id de la encuesta" required>
                <input type="number" id="numeroCapitulo" placeholder="Número del capitulo" required>
                <input type="text" id="tituloCapitulo" placeholder="Titulo del capitulo" required>
                <button type="submit" id="guardarCambios">GUARDAR CAMBIOS</button>
            </form>
        `;
    } else if (tipo === 'actualizar') {
        formulario = `
            <form id="encuestaActualizarForm">
                <input type="number" id="idCapituloActualizar" placeholder="Id del capitulo" required>
                <input type="number" id="idEncuestaActualizar" placeholder="Id de la encuesta" required>
                <input type="text" id="numeroCapituloActualizar" placeholder="Nuevo numero de capitulo" required>
                <input type="text" id="tituloCapituloActualizar" placeholder="Nuevo titulo del capitulo" required>
                <button type="submit" id="guardarCambios">GUARDAR CAMBIOS</button>
            </form>
        `;
    } else if (tipo === 'eliminar') {
        formulario = `
            <form id="CapituloEliminarForm">
                <input type="number" id="idCapituloEliminar" placeholder="Id del capitulo a eliminar" required>
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

    const form = document.getElementById(tipo === 'crear' ? 'encuestaCapituloForm' :
                                        tipo === 'actualizar' ? 'encuestaActualizarForm' :
                                        'CapituloEliminarForm');
    if (form) {
        form.addEventListener('submit', handleFormSubmit);
    }
}