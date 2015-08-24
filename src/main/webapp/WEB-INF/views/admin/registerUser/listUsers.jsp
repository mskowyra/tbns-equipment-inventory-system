<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script type="text/javascript">
    $(document).ready(function () {
        $('.nav-tabs a:first').tab('show'); // Select first tab
        $('.triggerRemove').click(function(e){
            e.preventDefault();
            $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemove").modal();
        })
    });
</script>

<div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Lista urzytkowników</h3>
                  <div class="box-tools">
                    <div class="input-group" style="width: 150px;">
                      <input type="text" name="table_search" class="form-control input-sm pull-right" placeholder="Search">
                      <div class="input-group-btn">
                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                      </div>
                    </div>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive no-padding">
                  <table class="table table-hover">
                    <tr>
                      <th>ID</th>
                      <th>Login</th>
                      <th>Status</th>
                      <th>Imię</th>
                      <th>Nazwisko</th>  
                      <th>E-mail</th>                    
                      <th>Data utworzenia</th>
                      <th>Data aktualizacji</th>
                      <th>Opcje</th>
                    </tr>
                    <c:forEach items="${users}" var="user">
                    <tr>
                      <td> ${user.id}</td>
                      <td>
                      <a href="<spring:url value="/users/${user.id}"/>">
                        ${user.name}
                      </a>
              		  </td>
                      <td><span class="label label-success">Aktywny</span></td>
                      <td>${user.first_name}</td>
                      <td>${user.last_name}</td>
                      <td>${user.email}</td>                       
                      <td>${user.dateCreate}</td>
                      <td>${user.dateUpdate}</td>
                      <td>
                		<a href="<spring:url value="/users/remove/${user.id}"/>" class="btn btn-danger triggerRemove">
                   		 Usuń
              			  </a>
           			 </td>
                    </tr> 
                    </c:forEach>                  
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div>
          </div>
















<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">RemoveBlog</h4>
            </div>
            <div class="modal-body">
                Really remove?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a href="" class="btn btn-danger removeBtn">Remove</a>
            </div>
        </div>
    </div>
</div>