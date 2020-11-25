package org.example.model;

public class Detail {
    protected Long iddetail;
    protected Long idmhs;
    private int physics;
    private int calculus;
    private int biology;

    public Detail(Long iddetail, Long idmhs, int physics, int calculus, int biology){
        setId(iddetail);
        setIdmhs(idmhs);
        setPhysics(physics);
        setCalculus(calculus);
        setBiology(biology);
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getCalculus() {
        return calculus;
    }

    public void setCalculus(int calculus) {
        this.calculus = calculus;
    }

    public int getBiology() {
        return biology;
    }

    public void setBiology(int biology) {
        this.biology = biology;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "iddetail=" + iddetail +
                ", idmhs='" + idmhs  +
                ", physics=" + physics +
                ", calculus=" + calculus +
                ", biology=" + biology +
                "}";
    }
    
    public Long getId() {
        return iddetail;
    }


    public void setId(Long id) {
        this.iddetail = id;
    }

    public Long getIdmhs() {
        return idmhs;
    }

    public void setIdmhs(Long idmhs) {
        this.idmhs = idmhs;
    }
}
