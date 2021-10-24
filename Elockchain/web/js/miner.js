/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function switchd(d,c,id)
        { 
            var e1=id+'1';
            var e2=id+'2';
            var e3=id+'3';
            if(document.getElementById(d).style.display == 'block' && c=='1')
            {
                document.getElementById(e1).style.display='none';
                document.getElementById(e2).style.display='block';
                document.getElementById(e3).style.display='none';
            }
            else if(document.getElementById(d).style.display == 'block' && c=='2')
            {
                document.getElementById(e1).style.display='none';
                document.getElementById(e2).style.display='none';
                document.getElementById(e3).style.display='block';
            }
            else if(document.getElementById(d).style.display == 'block' && c=='3')
            {
                document.getElementById(e1).style.display='block';
                document.getElementById(e2).style.display='none';
                document.getElementById(e3).style.display='none';
            }
            
            else
            {
                document.getElementById(e1).style.display='block';
                document.getElementById(e2).style.display='none';
                document.getElementById(e3).style.display='none';
            }
        }

