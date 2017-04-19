package org.deeplearning4j.nn.layers.recurrent;

import lombok.extern.slf4j.Slf4j;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Created by benny on 12/31/15.
 */
@Slf4j
public class FwdPassReturn {
    //First: needed by standard forward pass only
    public INDArray fwdPassOutput;
    //Arrays: Needed for backpropGradient only
    public INDArray[] fwdPassOutputAsArrays;
    public INDArray[] memCellState; //Pre nonlinearity
    public INDArray[] memCellActivations; //Post nonlinearity
    public INDArray[] iz;
    public INDArray[] ia;
    public INDArray[] fa;
    public INDArray[] oa;
    public INDArray[] ga;
    //Gate pre-outs: only needed if not using sigmoid. For sigmoid: sigmaPrime(z) = sigmoid(z) * (1-sigmoid(z)) -> use activations
    public INDArray[] fz;
    public INDArray[] oz;
    public INDArray[] gz;
    //Last 2: needed for rnnTimeStep only
    public INDArray lastAct;
    public INDArray lastMemCell;

    /**
     * This method is OPTIONAL, and written mostly for future use
     *
     * @param id
     */
    public void leverageTo(String id) {

        if (fwdPassOutput != null)
            fwdPassOutput = fwdPassOutput.leverageTo(id);

        if (fwdPassOutputAsArrays != null)
            for (int i = 0; i < fwdPassOutputAsArrays.length; i++)
                fwdPassOutputAsArrays[i] = fwdPassOutputAsArrays[i].leverageTo(id);

        if (memCellState != null)
            for (int i = 0; i < memCellState.length; i++)
                memCellState[i] = memCellState[i].leverageTo(id);

        if (memCellActivations != null)
            for (int i = 0; i < memCellActivations.length; i++)
                memCellActivations[i] = memCellActivations[i].leverageTo(id);

        if (fwdPassOutputAsArrays != null)
            for (int i = 0; i < fwdPassOutputAsArrays.length; i++)
                fwdPassOutputAsArrays[i] = fwdPassOutputAsArrays[i].leverageTo(id);

        if (iz != null)
            for (int i = 0; i < iz.length; i++)
                    iz[i] = iz[i].leverageTo(id);

        if (ia != null)
            for (int i = 0; i < ia.length; i++)
                ia[i] = ia[i].leverageTo(id);

        if (fa != null)
            for (int i = 0; i < fa.length; i++)
                fa[i] = fa[i].leverageTo(id);

        if (oa != null)
            for (int i = 0; i < oa.length; i++)
                oa[i] = oa[i].leverageTo(id);

        if (ga != null)
            for (int i = 0; i < ga.length; i++)
                ga[i] = ga[i].leverageTo(id);

        if (fz != null)
            for (int i = 0; i < fz.length; i++)
                fz[i] = fz[i].leverageTo(id);

        if (oz != null)
            for (int i = 0; i < oz.length; i++)
                oz[i] = oz[i].leverageTo(id);

        if (gz != null)
            for (int i = 0; i < gz.length; i++)
                gz[i] = gz[i].leverageTo(id);

        if (lastAct != null)
            lastAct = lastAct.leverageTo(id);

        if (lastMemCell != null)
            lastMemCell = lastMemCell.leverageTo(id);
    }
}
