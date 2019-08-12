package cn.lime.controller.device;

import cn.lime.entity.device.*;
import cn.lime.service.DeviceService;
import cn.lime.utils.ControllerMapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = {"/","index"},method = RequestMethod.GET)
    public String queryUser(HttpServletRequest request, HttpServletResponse response){
        return "home";
    }

    //设备台账表单提交
    @RequestMapping("deviceList/list")
    @ResponseBody
    public Map<String, Object> returnDeviceList(int page,int rows){
        return deviceService.selectAllDevice(page,rows);
    }

    @RequestMapping("device/deviceList")
    public String goToDeviceListAgain(){
        return "deviceList";
    }

    //设备台账中的设备信息弹窗
    @RequestMapping("deviceType/get/{id}")
    @ResponseBody
    public DeviceType returnDeviceListOfType(@PathVariable("id")String id){
        DeviceType deviceType = deviceService.selectDeviceTypeById(id);
        return deviceType;
    }

    //设备台账中下拉弹窗的设置
    @PostMapping("department/get_data")
    @ResponseBody
    public List<Department> returnDeviceListOfDepartment(){
        List<Department> departments = deviceService.selectAllDepartment();
        return departments;
    }
    //设备例检中employee下拉弹窗的设置
    @PostMapping("employee/get_data")
    @ResponseBody
    public List<Employee> returnDeviceCheckOfemployee(){
        List<Employee> employees = deviceService.selectAllEmployee();
        return employees;
    }

    //设备例检中设备类型下拉弹窗的设置
    @PostMapping("deviceType/get_data")
    @ResponseBody
    public List<DeviceType> returnDeviceCheckOfDeviceType(){
        List<DeviceType> deviceTypes = deviceService.selectAllDeviceType();
        return deviceTypes;
    }

    //设备故障中设备故障的下拉弹窗
    @PostMapping("deviceFault/get_data")
    @ResponseBody
    public List<DeviceFault> returnDeviceFaultOfDeviceFault(){
        List<DeviceFault> deviceFaults = deviceService.selectAllDeviceFault();
        return deviceFaults;
    }

    //设备维修中设备列表的下拉弹窗
    @PostMapping("deviceList/get_data")
    @ResponseBody
    public List<Device> returnDeviceMaintainOfDeviceList(){
        List<Device> devices = deviceService.selectAllDevice();
        return devices;
    }

    // @RequestMapping(value = "deviceType/update_all" , method = RequestMethod.POST)
    //设备台账中保管人弹窗的设置
    @PostMapping("employee/update_all")
    @ResponseBody
    public Map<String, Object> returnDeviceListOfEmployeeList(Employee employee){
       int i = deviceService.updateEmployeeByReturnMess(employee);
       return ControllerMapUtil.MapString(i==1);
    }
    //设备台账中的设备信息弹窗修改
    @RequestMapping("employee/edit_judge")
    @ResponseBody
    public void returnDeviceListOfEmployeeUpdate(){

    }

    //@RequestMapping(value = "deviceType/update_all" , method = RequestMethod.POST)
    //设备台账中设备种类弹窗的更新
    @PostMapping("deviceType/update_all")
    @ResponseBody
    public Map<String, Object> returnDeviceListOfTypeList(DeviceType deviceType){
        int i = deviceService.updateByPrimaryKeySelective(deviceType);
        return ControllerMapUtil.MapString(i==1);
    }

    @RequestMapping("deviceType/edit_judge")
    @ResponseBody
    public void returnDeviceListOfTypeUpdate(){
    }

    //设备台账中的设备信息弹窗修改
    @RequestMapping("employee/get/{id}")
    @ResponseBody
    public Employee returnDeviceListOfEmployee(@PathVariable("id")String id){
        Employee employee = deviceService.selectEmployeeById(id);
        return employee;
    }


    //设备例检中的设备名称弹窗的修改
    @PostMapping("deviceList/update_all")
    @ResponseBody
    public Map<String, Object> returnDeviceCheckOfDeviceList(Device device){
        int i = deviceService.updateByPrimaryKeySelective(device);
        return ControllerMapUtil.MapString(i==1);
    }

    @RequestMapping("deviceList/edit_judge")
    @ResponseBody
    public void returnDeviceCheckOfDeviceUpdate(){

    }


    //设备型号
    @RequestMapping("deviceType/list")
    @ResponseBody
    public Map<String, Object> returnDeviceType(int page,int rows){
        PageHelper.startPage(page,rows);
        List<DeviceType> deviceTypes = deviceService.selectAllDeviceType();
        PageInfo<DeviceType> pageInfo = new PageInfo<>(deviceTypes);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceTypes);
        return map;
    }

    @RequestMapping("device/deviceType")
    public String goToDeviceTypeAgain(){
        return "deviceType";
    }



    //设备例检
    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public Map<String, Object> returnDeviceCheck(int page,int rows){
        PageHelper.startPage(page,rows);
        List<DeviceCheck> deviceChecks = deviceService.selectAllDeviceCheck();
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(deviceChecks);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceChecks);
        return map;
    }

    @RequestMapping("device/deviceCheck")
    public String goToDeviceCheckAgain(){
        return "deviceCheck";
    }

    //设备台账中的设备信息弹窗修改
    @RequestMapping("deviceList/get/{id}")
    @ResponseBody
    public Device returnDeviceCheckOfDevice(@PathVariable("id")String id){
        Device device = deviceService.selectByPrimaryKey(id);
        return device;
    }

    //设备故障
    @RequestMapping("deviceFault/list")
    @ResponseBody
    public Map<String, Object> returnDeviceFault(int page,int rows){
        PageHelper.startPage(page,rows);
        List<DeviceFault> deviceFaults = deviceService.selectAllDeviceFault();
        PageInfo<DeviceFault> pageInfo = new PageInfo<>(deviceFaults);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceFaults);
        return map;
    }

    @RequestMapping("deviceFault/edit_judge")
    @ResponseBody
    public void returnDeviceMaintainOfTypeUpdate(){
    }

    //设备维修
    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public Map<String, Object> returnDeviceMaintain(int page,int rows){
        PageHelper.startPage(page,rows);
        List<DeviceMaintain> deviceMaintains = deviceService.selectAllDeviceMaintain();
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(deviceMaintains);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceMaintains);
        return map;
    }

    @RequestMapping("device/deviceMaintain")
    public String goToDeviceMaintainAgain(){
        return "deviceMaintain";
    }


    //设备维修中查看故障编号
    @RequestMapping("deviceFault/get/{id}")
    @ResponseBody
    public DeviceFault returnDeviceMaintainOfFault(@PathVariable("id")String id){
        DeviceFault deviceFault = deviceService.selectDeviceFaultById(id);
        return deviceFault;
    }

    //设备维修中故障编号弹窗信息的修改
    @RequestMapping("device/deviceFault")
    public String goToDeviceFaultAgain(){
        return "deviceFault";
    }


    @PostMapping("deviceFault/update_all")
    @ResponseBody
    public Map<String, Object> returnDeviceMaintainOfTypeFault(DeviceFault deviceFault){
        int i = deviceService.updateByPrimaryKeySelective(deviceFault);
        return ControllerMapUtil.MapString(i==1);
    }

    //设备台账中的模糊查询 通过设备编号查询  searchValue=003&page=1&rows=30
    @GetMapping("deviceList/search_device_by_deviceId")
    @ResponseBody
    public Map<String,Object> InDeviceListsearchDeviceByDeviceId(String searchValue,int page,int rows){
        PageHelper.startPage(page,rows);
        String searchValue1 = "%" + searchValue + "%";
        List<Device> devices = deviceService.likeSelectDeviceByDeviceId(searchValue1);
        PageInfo<Device> pageInfo = new PageInfo<>(devices);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",devices);
        return map;
    }

    //设备台账中的模糊查询 通过设备名称查询  searchValue=42&page=1&rows=30
    @GetMapping("deviceList/search_device_by_deviceName")
    @ResponseBody
    public Map<String,Object> InDeviceListsearchDeviceByDeviceName(String searchValue,int page,int rows){
        PageHelper.startPage(page,rows);
        String searchValue1 = "%" + searchValue + "%";
        List<Device> devices = deviceService.likeSelectDeviceByDeviceName(searchValue1);
        PageInfo<Device> pageInfo = new PageInfo<>(devices);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",devices);
        return map;
    }

    //设备台账中的模糊查询 通过设备名称查询  searchValue=42&page=1&rows=30
    @GetMapping("deviceList/search_device_by_deviceTypeName")
    @ResponseBody
    public Map<String,Object> InDeviceListsearchDeviceByDeviceTypeName(String searchValue,int page,int rows){
        PageHelper.startPage(page,rows);
        String searchValue1 = "%" + searchValue + "%";
        List<Device> devices = deviceService.likeSelectDeviceByDeviceTypeName(searchValue1);
        PageInfo<Device> pageInfo = new PageInfo<>(devices);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",devices);
        return map;
    }

    //设备种类中的模糊查询 通过设备种类编号查询  searchValue=42&page=1&rows=30
    @GetMapping("deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public Map<String,Object> InDeviceTypesearchDeviceByDeviceTypeId(String searchValue,int page,int rows){
        PageHelper.startPage(page,rows);
        String searchValue1 = "%" + searchValue + "%";
        List<DeviceType> deviceTypes=deviceService.likeSelectDeviceTypeByDeviceTypeId(searchValue1);
        PageInfo<DeviceType> pageInfo = new PageInfo<>(deviceTypes);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceTypes);
        return map;
    }

    //设备种类中的模糊查询 通过设备种类名称查询 searchValue=42&page=1&rows=30
    @GetMapping("deviceType/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public Map<String,Object> InDeviceTypesearchDeviceByDeviceTypeName(String searchValue,int page,int rows){
        PageHelper.startPage(page,rows);
        String searchValue1 = "%" + searchValue + "%";
        List<DeviceType> deviceTypes=deviceService.likeSelectDeviceTypeByDeviceTypeName(searchValue1);
        PageInfo<DeviceType> pageInfo = new PageInfo<>(deviceTypes);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceTypes);
        return map;
    }


    //设备例检中的模糊查询 通过设备例检编号查询
    @GetMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public Map<String,Object> InDeviceChecksearchDeviceCheckByDeviceCheckId(String searchValue,int page,int rows){
        PageHelper.startPage(page,rows);
        String searchValue1 = "%" + searchValue + "%";
        List<DeviceCheck> deviceChecks=deviceService.likeSelectDeviceCheckByDeviceCheckId(searchValue1);
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(deviceChecks);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceChecks);
        return map;
    }

    //设备例检中的模糊查询 通过设备例检编号查询
    @GetMapping("deviceCheck/search_deviceCheck_by_deviceName")
    @ResponseBody
    public Map<String,Object> InDeviceChecksearchDeviceCheckByDeviceCheckName(String searchValue,int page,int rows){
        PageHelper.startPage(page,rows);
        String searchValue1 = "%" + searchValue + "%";
        List<DeviceCheck> deviceChecks=deviceService.likeSelectDeviceCheckByDeviceName(searchValue1);
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(deviceChecks);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceChecks);
        return map;
    }

    //设备故障中的模糊查询 通过设备故障编号查询
    @GetMapping("deviceFault/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public Map<String,Object> InDeviceFaultsearchDeviceFaultByDeviceFaultId(String searchValue,int page,int rows){
        PageHelper.startPage(page,rows);
        String searchValue1 = "%" + searchValue + "%";
        List<DeviceFault> deviceFaults=deviceService.likeSelectDeviceFaultByDeviceFaultId(searchValue1);
        PageInfo<DeviceFault> pageInfo = new PageInfo<>(deviceFaults);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceFaults);
        return map;
    }

    //设备故障中的模糊查询 通过设备故障编号查询
    @GetMapping("deviceFault/search_deviceFault_by_deviceName")
    @ResponseBody
    public Map<String,Object> InDeviceFaultsearchDeviceFaultByDeviceName(String searchValue,int page,int rows){
        PageHelper.startPage(page,rows);
        String searchValue1 = "%" + searchValue + "%";
        List<DeviceFault> deviceFaults=deviceService.likeSelectDeviceFaultByDeviceName(searchValue1);
        PageInfo<DeviceFault> pageInfo = new PageInfo<>(deviceFaults);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceFaults);
        return map;
    }

    //设备维修中的模糊查询 通过设备维修编号查询 deviceMaintain/list
    @GetMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public Map<String,Object> InDeviceMaintainsearchDeviceMaintainByDeviceMaintainId(String searchValue,int page,int rows){
        PageHelper.startPage(page,rows);
        String searchValue1 = "%" + searchValue + "%";
        List<DeviceMaintain> deviceMaintains=deviceService.likeSelectDeviceMaintainByDeviceMaintainId(searchValue1);
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(deviceMaintains);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceMaintains);
        return map;
    }

    //设备维修中的模糊查询 通过故障编号查询
    @GetMapping("deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public Map<String,Object> InDeviceMaintainsearchDeviceMaintainByDeviceFaultId(String searchValue,int page,int rows){
        PageHelper.startPage(page,rows);
        String searchValue1 = "%" + searchValue + "%";
        List<DeviceMaintain> deviceMaintains=deviceService.likeSelectDeviceMaintainByDeviceFaultId(searchValue1);
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(deviceMaintains);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("rows",deviceMaintains);
        return map;
    }

    //设备台账的增加  deviceList/add_judge
    @RequestMapping("deviceList/add_judge")
    @ResponseBody
    public void goToDeviceListAddJudge(){

    }

    @RequestMapping("deviceList/add")
    public String goToDeviceListAdd(){
        return "deviceList_add";
    }

    @RequestMapping("deviceList/insert")
    @ResponseBody
    public Map<String,Object> insertDeviceToList(Device device){
        int i = deviceService.insert(device);
        return ControllerMapUtil.MapString(i==1);
    }

    //设备台账的编辑  deviceList/edit_judge
    //上面有编辑deviceList/edit_judge，所以会发生冲突
  /*  @RequestMapping("deviceList/edit_judge")
    @ResponseBody
    public void goToDeviceListEditJudge(){

    }*/

    @RequestMapping("deviceList/edit")
    public String goToDeviceListEdit(){
        return "deviceList_edit";
    }

   @RequestMapping("deviceList/update")
    @ResponseBody
    public Map<String,Object> updateDeviceToList(Device device){
        int i = deviceService.updateByPrimaryKeySelective(device);
        return ControllerMapUtil.MapString(i==1);
    }

    @RequestMapping("deviceList/delete_judge")
    @ResponseBody
    public void goToDeviceListEditJudge(){

    }

    @RequestMapping("deviceList/delete_batch")
    @ResponseBody
    public Map<String,Object> delectDeviceToList(String ids){
        int i = deviceService.deleteByPrimaryKey(ids);
        return ControllerMapUtil.MapString(i==1);
    }

    //设备种类的增加  deviceList/add_judge
    @RequestMapping("deviceType/add_judge")
    @ResponseBody
    public void goToDeviceTypeAddJudge(){

    }

    @RequestMapping("deviceType/add")
    public String goToDeviceTypeAdd(){
        return "deviceType_add";
    }

    @RequestMapping("deviceType/insert")
    @ResponseBody
    public Map<String,Object> insertDeviceTypeToList(DeviceType deviceType){
        int i = deviceService.insert(deviceType);
        return ControllerMapUtil.MapString(i==1);
    }
    //设备种类的编辑按钮
    @RequestMapping("deviceType/edit")
    public String goToDeviceTypeListEdit(){
        return "deviceType_edit";
    }

    @RequestMapping("deviceType/update")
    @ResponseBody
    public Map<String,Object> updateDeviceTypeToList(DeviceType deviceType){
        int i = deviceService.updateByPrimaryKeySelective(deviceType);
        return ControllerMapUtil.MapString(i==1);
    }
    //设备种类的删除按钮
    @RequestMapping("deviceType/delete_judge")
    @ResponseBody
    public void goToDeviceTypeListdeleteJudge(){

    }

    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public Map<String,Object> delectDeviceTypeToList(String ids){
        int i = deviceService.deleteDeviceTypeByPrimaryKey(ids);
        return ControllerMapUtil.MapString(i==1);
    }

    //设备例检的增加
    @RequestMapping("deviceCheck/add_judge")
    @ResponseBody
    public void goTodeviceCheckAddJudge(){

    }

    @RequestMapping("deviceCheck/add")
    public String goTodeviceCheckAdd(){
        return "deviceCheck_add";
    }

    @RequestMapping("deviceCheck/insert")
    @ResponseBody
    public Map<String,Object> insertdeviceCheckToList(DeviceCheck deviceCheck){
        int i = deviceService.insert(deviceCheck);
        return ControllerMapUtil.MapString(i==1);
    }

    //设备例检的编辑按钮
    @RequestMapping("deviceCheck/edit_judge")
    @ResponseBody
    public void goToDeviceCheckToEdit(){

    }

    @RequestMapping("deviceCheck/edit")
    public String goTodeviceCheckListEdit(){
        return "deviceCheck_edit";
    }

    @RequestMapping("deviceCheck/update")
    @ResponseBody
    public Map<String,Object> updatedeviceCheckToList(DeviceCheck deviceCheck){
        int i = deviceService.updateByPrimaryKeySelective(deviceCheck);
        return ControllerMapUtil.MapString(i==1);
    }
    //设备例检的删除按钮
    @RequestMapping("deviceCheck/delete_judge")
    @ResponseBody
    public void goTodeviceCheckListdeleteJudge(){

    }

    @RequestMapping("deviceCheck/delete_batch")
    @ResponseBody
    public Map<String,Object> delectdeviceCheckToList(String ids){
        int i = deviceService.deletedeviceCheckByPrimaryKey(ids);
        return ControllerMapUtil.MapString(i==1);
    }

    //设备故障的增加
    @RequestMapping("deviceFault/add_judge")
    @ResponseBody
    public void goTodeviceFaultAddJudge(){

    }

    @RequestMapping("deviceFault/add")
    public String goTodeviceFaultAdd(){
        return "deviceFault_add";
    }

    @RequestMapping("deviceFault/insert")
    @ResponseBody
    public Map<String,Object> insertdeviceFaultToList(DeviceFault deviceFault){
        int i = deviceService.insert(deviceFault);
        return ControllerMapUtil.MapString(i==1);
    }

    //设备例检的编辑按钮
    //上面已经出现了
    /*@RequestMapping("deviceFault/edit_judge")
    @ResponseBody
    public void goTodeviceFaultToEdit(){

    }*/

    @RequestMapping("deviceFault/edit")
    public String goTodeviceFaultListEdit(){
        return "deviceFault_edit";
    }

    @RequestMapping("deviceFault/update")
    @ResponseBody
    public Map<String,Object> updatedeviceFaultToList(DeviceFault deviceFault){
        int i = deviceService.updateByPrimaryKeySelectiveDeviceFault(deviceFault);
        return ControllerMapUtil.MapString(i==1);
    }
    //设备例检的删除按钮
    @RequestMapping("deviceFault/delete_judge")
    @ResponseBody
    public void goToddeviceFaultListdeleteJudge(){

    }

    @RequestMapping("deviceFault/delete_batch")
    @ResponseBody
    public Map<String,Object> delectdeviceFaultToList(String ids){
        int i = deviceService.deleteByPrimaryKeyDeviceFault(ids);
        return ControllerMapUtil.MapString(i==1);
    }







    //设备维修的增加
    @RequestMapping("deviceMaintain/add_judge")
    @ResponseBody
    public void goTodeviceMaintainAddJudge(){

    }

    @RequestMapping("deviceMaintain/add")
    public String goTodeviceMaintainAdd(){
        return "deviceMaintain_add";
    }

    @RequestMapping("deviceMaintain/insert")
    @ResponseBody
    public Map<String,Object> insertdeviceMaintainToList(DeviceMaintain deviceMaintain){
        int i = deviceService.insert(deviceMaintain);
        return ControllerMapUtil.MapString(i==1);
    }

    //设备维修的编辑按钮
    @RequestMapping("deviceMaintain/edit_judge")
    @ResponseBody
    public void goTodeviceFaultToEdit(){

    }

    @RequestMapping("deviceMaintain/edit")
    public String goTodeviceMaintainListEdit(){
        return "deviceMaintain_edit";
    }

    @RequestMapping("deviceMaintain/update")
    @ResponseBody
    public Map<String,Object> updatedeviceMaintainToList(DeviceMaintain deviceMaintain){
        int i = deviceService.updateByPrimaryKeySelective(deviceMaintain);
        return ControllerMapUtil.MapString(i==1);
    }
    //设备例检的删除按钮
    @RequestMapping("deviceMaintain/delete_judge")
    @ResponseBody
    public void goToddeviceMaintainListdeleteJudge(){

    }

    @RequestMapping("deviceMaintain/delete_batch")
    @ResponseBody
    public Map<String,Object> delectdevicMaintainToList(String ids){
        int i = deviceService.deleteByPrimaryKeyDeviceMaintain(ids);
        return ControllerMapUtil.MapString(i==1);
    }
}
