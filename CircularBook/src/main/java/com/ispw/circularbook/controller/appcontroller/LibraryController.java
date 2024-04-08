package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.Bean.LibraryBean;
import com.ispw.circularbook.engineering.DAO.LibraryDAO;
import com.ispw.circularbook.model.LibraryModel;

public class LibraryController {

    public void updateLibrary(String email,String camp,String newValue)
    {
        LibraryDAO.updateLibrary(email,camp,newValue);
    }

    public LibraryBean searchLibrary(String email) {

        LibraryModel libraryModel;
        libraryModel = LibraryDAO.searchLibraryByEmail(email);
        LibraryBean libraryBean = new LibraryBean(libraryModel.getEmail(), libraryModel.getNomeLib(), libraryModel.getCitta(), libraryModel.getVia(),libraryModel.getTelNumber());
        return libraryBean;
    }
}
