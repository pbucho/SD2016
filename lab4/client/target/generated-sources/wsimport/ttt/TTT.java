
package ttt;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TTT", targetNamespace = "http://ttt/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TTT {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "currentBoard", targetNamespace = "http://ttt/", className = "ttt.CurrentBoard")
    @ResponseWrapper(localName = "currentBoardResponse", targetNamespace = "http://ttt/", className = "ttt.CurrentBoardResponse")
    @Action(input = "http://ttt/TTT/currentBoardRequest", output = "http://ttt/TTT/currentBoardResponse")
    public String currentBoard();

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "play", targetNamespace = "http://ttt/", className = "ttt.Play")
    @ResponseWrapper(localName = "playResponse", targetNamespace = "http://ttt/", className = "ttt.PlayResponse")
    @Action(input = "http://ttt/TTT/playRequest", output = "http://ttt/TTT/playResponse")
    public boolean play(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkWinner", targetNamespace = "http://ttt/", className = "ttt.CheckWinner")
    @ResponseWrapper(localName = "checkWinnerResponse", targetNamespace = "http://ttt/", className = "ttt.CheckWinnerResponse")
    @Action(input = "http://ttt/TTT/checkWinnerRequest", output = "http://ttt/TTT/checkWinnerResponse")
    public int checkWinner();

}
