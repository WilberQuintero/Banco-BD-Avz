-- triggers de banco
use avance1bd;

-- cuenta
delimiter //
create trigger numeroCuenta
before insert on cuentas
for each row
begin
    declare numCue bigint;
    set numCue = floor(rand() * 10000000000000000);
    set new.numeroCuenta = lpad(numCue, 16, '0');
    set new.fechaApertura = now();
end//

delimiter ;

-- Retiro Sin Cuenta
delimiter //

create trigger folio
before insert on retirossincuenta
for each row
begin
    declare max_folio bigint;
    declare contra bigint;
    select max(folio) into max_folio from retirossincuenta;
    set new.folio = coalesce(max_folio, 0) + 1;
    set new.fecha = now();
    set new.fechaFin = date_add(new.fecha, INTERVAL 10 MINUTE);
    set contra = floor(rand() * 99999999);
    set new.contra = lpad(contra, 8, '0');
end//

delimiter ;

 --  drop trigger folio;

