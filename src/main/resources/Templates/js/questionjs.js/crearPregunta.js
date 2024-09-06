function guardarEncuestaCrear() {
    const idCapitulo = document.getElementById('idCapitulo').value;
    const numeroPregunta = document.getElementById('numeroPregunta').value;
    const responseType = document.getElementById('responseType').value;
    const textoPregunta = document.getElementById('textoPregunta').value;
    const comentarioPregunta = document.getElementById('comentarioPregunta').value;

    // Obtener las opciones de respuesta si el tipo de respuesta es "multiple"
    let options = [];
    if (responseType === 'multiple') {
        const optionInputs = document.querySelectorAll('input[name="optionText[]"]');
        options = Array.from(optionInputs).map(input => input.value).filter(value => value.trim() !== '');
    }

    fetch('http://localhost:8080/questionapi', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            chapterId: idCapitulo,
            questionNumber: numeroPregunta,
            responseType: responseType,
            questionText: textoPregunta,
            commentQuestion: comentarioPregunta,
            options: options // Solo se incluirá si hay opciones
        }),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('Success:', data);
        alert('Pregunta creada con éxito!');
        // Limpiar el formulario o redirigir al usuario si es necesario
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al crear la pregunta.');
    });
}
