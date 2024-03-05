package velazquez.services;

import velazquez.models.Tipo;

import java.util.List;

public interface TipoServices {
    public void deleteTipo(Tipo tipo);
    public void insertTipo(Tipo tipo);
    public Tipo updateTipo(Tipo tipo);
    public Tipo selectTipo(Tipo tipo);
    public List<Tipo> selectAllTipos(Tipo tipo);
}
