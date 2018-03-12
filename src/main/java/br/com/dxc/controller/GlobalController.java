package br.com.dxc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import br.com.dxc.domain.BatchJobExecution;
import br.com.dxc.dto.GlobalProcessamentoRequestDTO;
import br.com.dxc.service.JobService;

@RestController
@RequestMapping({"rest/global"})
public class GlobalController extends AbstractController {

    @Autowired
    private JobService jobService;

    @Resource(name = "GLOBAL_JOB")
    private Job globalJob;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

    @RequestMapping(value = {"action/processar"}, method = {RequestMethod.GET})
    @PreAuthorize("hasRole('PROCESSAMENTO_EXECUTAR')")
    public BatchJobExecution processar(@Valid @RequestBody final GlobalProcessamentoRequestDTO dto) {
//        this.globalService.validarProcessamento(dto);
        JobParametersBuilder builder = new JobParametersBuilder();
        builder.addDate("dataProcessamento", dto.getDataProcessamento().toDate());

        // parametros para geração de boletos grafica
//        builder.addDate("dataProcessamentoAtual", globalService.get().getDataProcessamentoAtual().toDate());
//        builder.addString("input.file.path", path);
//        builder.addString("input.file.name", globalService.get().getDataProcessamentoAtual().toString("yyyyMMdd").concat("_BOLETO").concat(".txt"));
        return this.jobService.run(this.globalJob, builder);
    }

}
