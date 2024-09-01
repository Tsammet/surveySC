function guardarEncuestaCrear() {
    const idEncuesta = document.getElementById('idEncuesta').value;
    const numeroCapitulo = document.getElementById('numeroCapitulo').value;
    const tituloCapitulo = document.getElementById('tituloCapitulo').value;

    fetch('http://localhost:8080/chapterapi', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            surveyId : idEncuesta,
            chapterTitle: tituloCapitulo,
            chapterNumber: numeroCapitulo,
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
        alert('Capitulo creado con éxito!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al crear el capitulo.');
    });
}