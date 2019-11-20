
function tacharTexto()
{

    if(document.getElementById('parrafo1').classList.contains('tachado'))
    {
        document.getElementById('parrafo1').classList.remove('tachado');
    }
    else
    {
        document.getElementById('parrafo1').classList.add('tachado')
    }

    
}