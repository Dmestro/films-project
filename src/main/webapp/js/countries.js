/**
 * Created by Lytki on 14.04.2017.
 */
$(document).ready(()=>{
    getAllCountries();
    activateDialogButtons();
});
var actionFlag;
var ID;
var COUNTRY_NAME;
var ASAS;
function getAllCountries(){
    $.get("/countries",(data)=>{
        var countries = data.countries;
        var $table = $('.table-countries>tbody');
        $table.empty();

        countries.forEach((country)=>{
            var tempalte = `<tr>
                <th class="country-id-${country.id}"scope="row">${country.id}</th>
                <td class="country-name-${country.id}">${country.countryName}</td>
                <td><a class="changer"><i id-attr="${country.id}" class="glyphicon glyphicon-pencil"></i></a>
                    <a class="remover" "><i id-attr="${country.id}" class="glyphicon glyphicon-remove"></i></a></td>
            </tr>`;
            $table.append(tempalte);
        });

        var $countryChangers = $('.changer');

        for(var i=0;i<$countryChangers.length;i++){
            $countryChangers[i].onclick=(event)=>{
                console.log(event.target);
                console.log($(event.target));
                ID=$(event.target).attr('id-attr');
                COUNTRY_NAME = $('.country-name-'+ID).text();
                var $opacifier = $('.opacifier');
                var $addCountryDialog = $('.add-dialog');
                $opacifier.show();
                $addCountryDialog.show();
                $('#country-name-input>input').val(COUNTRY_NAME);
                actionFlag="UPDATE";
            };
        }

        var $countryRemovers = $('.remover');
        for(var i=0;i<$countryRemovers.length;i++){
            $countryRemovers[i].onclick=(event)=>{
                console.log(event.target);
                console.log($(event.target));
                ID=$(event.target).attr('id-attr');
                $.post('/countries',{action:"DELETE",id:ID},function(){getAllCountries();
                });

            };
        }



    })


}
function activateDialogButtons(){
    $('#add-dialog-button').click(()=>{
        var $opacifier = $('.opacifier');
        var $addCountryDialog = $('.add-dialog');
        $('#country-name-input>input').val("");
        $opacifier.show();
        $addCountryDialog.show();
        $('#country-name-input>input').focus();

        actionFlag="ADD";
    });
    $('#cancel-add-button').click(()=>{
        var $opacifier = $('.opacifier');
        var $addCountryDialog = $('.add-dialog');
        $opacifier.hide();
        $addCountryDialog.hide();
    });

    $('#add-button').click(()=>{
        if(actionFlag==="ADD"){
            var country=$('#country-name-input>input').val();
            console.log(country);
            $.post('/countries',{action:actionFlag,countryName:country},function(){getAllCountries();});
            var $opacifier = $('.opacifier');
            var $addCountryDialog = $('.add-dialog');
            $opacifier.hide();
            $addCountryDialog.hide();

        } 
        
        if(actionFlag==="UPDATE"){
            $.post('/countries',{action:actionFlag,country:{id:ID,countryName:$('#country-name-input>input').val()}},function(){getAllCountries();});
            var $opacifier = $('.opacifier');
            var $addCountryDialog = $('.add-dialog');
            $opacifier.hide();
            $addCountryDialog.hide();

        }
    });


    
}