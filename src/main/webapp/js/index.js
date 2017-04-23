$(document).ready(()=>{
    $('#films-add-button').click(()=>{
        location.href="/create_film.jsp";
    });

    $.get('/films',(data)=>{
        console.log(data);
        for(var i=0;i<data.length;i++){
            var template=`
            <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4>${data[i].title}</h4>
                <div style="position:absolute; top:0px;right:30px;">
                    <h3>Год: ${data[i].releaseDate}</h3>
                </div>
            </div>
            <div class="panel-body">
                <div class="col-md-4">
                    <iframe width="100%" height="50%" src="${data[i].trailerUrl}" frameborder="0" allowfullscreen></iframe>
                </div>
                <div class="col-md-8">
                    <div class="col-md-12" id="actors-${data[i].id}">
                        <span class="label label-warning">В ролях:</span> 
                    </div>
                    <div class="col-md-12" style="margin-top:35px;"><p>${data[i].description}</p></div>
                    <div class="col-md-offset-9 col-md-1"><a href="/film.jsp?id=${data[i].id}" class="btn btn-primary">Подробнее>></a></div>
                </div>
            </div>
            <div class="panel-footer" id="genres-${data[i].id}">
                <div style="position:absolute; right:30px; bottom:30px;" id="raiting-${data[i].id}">
                </div>
            </div>
        </div>
    </div>
            `;
            $('#main-container').append(template);
            var actors = data[i].actors;
            for(var j=0;j<actors.length;j++){
                $('#actors-'+data[i].id).append(` <span class="label label-default">${actors[j].firstName+" "+actors[j].lastName}</span>`);
            }
            var genres = data[i].genres;
            for(var k=0;k<genres.length;k++){
                $('#genres-'+data[i].id).append(`<span class="label label-info" style="margin-right: 5px;">${genres[k].name}</span>`);
            }

            for(var p=0;p<data[i].raiting;p++){
                $('#raiting-'+data[i].id).append(`<i class="glyphicon glyphicon-heart"></i>`);
            }
            for(var p1=5-data[i].raiting;p1>0;p1--){
                $('#raiting-'+data[i].id).append(`<i class="glyphicon glyphicon-heart-empty"></i>`);
            }

        }
    })
});
