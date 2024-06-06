package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.LibraryBean;
import com.ispw.circularbook.engineering.bean.UpdateInfoBean;
import com.ispw.circularbook.engineering.dao.LibraryDAO;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.LibraryModel;

public class LibraryController {

    public void updateLibrary(UpdateInfoBean updateInfoBean)
    {
        LibraryDAO.updateLibrary(updateInfoBean);
        this.updateSession(updateInfoBean);
    }

    private void updateSession(UpdateInfoBean updateInfoBean)
    {
        Session.getCurrentSession().getLibrary().setNomeLib(updateInfoBean.getNameLibrary());
        Session.getCurrentSession().getLibrary().setVia(updateInfoBean.getVia());
        Session.getCurrentSession().getLibrary().setTelNumber(updateInfoBean.getNumberPhone());
        Session.getCurrentSession().getLibrary().setCity(updateInfoBean.getCity());
    }

    public LibraryBean searchLibrary(String email) {

        LibraryBean libraryBean;
        libraryBean = LibraryDAO.searchLibraryByEmail(email);
        LibraryModel libraryModel = new LibraryModel(libraryBean.getEmail(), libraryBean.getNomeLib(), libraryBean.getCityString(), libraryBean.getVia(),libraryBean.getTelNumber());
        return libraryBean;
    }
}
