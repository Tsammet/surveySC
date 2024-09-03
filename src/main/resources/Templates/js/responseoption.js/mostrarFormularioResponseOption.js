function mostrarFormulario(tipo) {
    const rightPanel = document.getElementById('rightPanel');
    let formulario = '';

    if (tipo === 'crear') {
        formulario = `
            <form id="encuestaRespuestaForm">
                <input type="text" id="questionId" placeholder="Id de la pregunta" required>
                <input type="text" id="optionValue" placeholder="Valor de la opción(1,2,3, o 4)" required>
                <input type="text" id="optionText" placeholder="Texto de la opción de respuesta" required>
                <input type="text" id="commentResponse" placeholder="Comentario de la respuesta" required>
                
                <button type="submit" id="questionId">GUARDAR CAMBIOS</button>
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
        } 
    }

    const form = document.getElementById(tipo === 'crear' ? 'encuestaRespuestaForm' :
                                        tipo === 'actualizar' ? 'encuestaActualizarForm' :
                                        'CapituloEliminarForm');
    if (form) {
        form.addEventListener('submit', handleFormSubmit);
    }
}